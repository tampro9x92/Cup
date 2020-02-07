package com.t3h.bigproject.fragment.screen.login.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Resources;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Bundle;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;

import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.t3h.bigproject.R;
import com.t3h.bigproject.base.fragment.BaseFragment;

import com.t3h.bigproject.fragment.screen.login.presenter.LoginPresenterImpl;
import com.t3h.bigproject.fragment.screen.login.view.LoginView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Calendar;

import java.util.regex.Pattern;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class Login extends BaseFragment<LoginPresenterImpl> implements LoginView, View.OnClickListener {
	private EditText edtEmail, edtPassword, edtFullName, edtPhoneNumber, edtAddress;
	private RadioGroup rgSex;
	private RadioButton rbMail, rbFemail;
	private TextView tvDate, tvForgetPassword;
	private Button btnLogin, btnRegister;
	private ImageView imvBack;
	private TextView tvTitle;
	private LinearLayout lnMainLoginRegister;
	private LinearLayout lnLoginRegisterButton;
	private LinearLayout lnDate;
	private RelativeLayout rlPhoneNumber;
	private static final Pattern PASSWORD = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
	private static final Pattern PHONENUMBER =Pattern.compile("^[0-9].{7,11}$");
	private Calendar currentTime;
//	google signin
	private GoogleSignInClient googleSignInClient;
	private Button btnLoginGoogle;
	private static int RC_SIGN_IN = 0;

//	facebook sigin and register
	private CallbackManager callbackManager;
	private Button btnLoginFacebook;

	private AnimationDrawable animationDrawable;
	private String image_url;
	public boolean typeLogin = false;

	private String email;
	private String password;
	private String fullName;
	private String address;
	private String phonenumber;
	private String date;
	private boolean sex;
	@Override
	protected View setLayoutFragment(LayoutInflater inflater, ViewGroup container) {
		return inflater.inflate(R.layout.fragment_login, container, false);
	}

	@Override
	protected LoginPresenterImpl getPresenter() {
		return new LoginPresenterImpl(this, activity);
	}

	@Override
	public void onInit() {
		initView();
		checkingLogin();
		if (isNetworkConnected()) {
			googleSignIn();
			facebookSignIn();
			checkLoginGoogle();
		} else {
			Toast.makeText(getActivity(), "Please check your network", Toast.LENGTH_SHORT).show();
		}
	}


	public void checkLoginGoogle() {
		GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(getContext());
		//TODO change Layout Here

	}

	private boolean isNetworkConnected() {
		ConnectivityManager connManager = (ConnectivityManager) getActivity().getSystemService(CONNECTIVITY_SERVICE);
		NetworkInfo mWifi = connManager.getActiveNetworkInfo();
		if (mWifi == null || !mWifi.isConnected()) {
			return false;
		}
		if (mWifi.isRoaming()) {
			return false;
		}
		return true;
	}

	private void initView() {
		currentTime = Calendar.getInstance();
		tvForgetPassword = vFragmentLayout.findViewById(R.id.tvForgetPassword);
		edtEmail = vFragmentLayout.findViewById(R.id.edtEmail);
		edtPassword = vFragmentLayout.findViewById(R.id.edtPassword);
		edtAddress = vFragmentLayout.findViewById(R.id.edtAddress);
		edtFullName = vFragmentLayout.findViewById(R.id.edtFullName);
		edtPhoneNumber = vFragmentLayout.findViewById(R.id.edtPhonenumber);
		tvDate = vFragmentLayout.findViewById(R.id.tvDate);
		rgSex = vFragmentLayout.findViewById(R.id.rgSex);
		rbFemail = vFragmentLayout.findViewById(R.id.rbFemail);
		rbMail = vFragmentLayout.findViewById(R.id.rbMale);
		lnDate = vFragmentLayout.findViewById(R.id.lnDate);
		btnLogin = vFragmentLayout.findViewById(R.id.btnLogin);
		btnRegister = vFragmentLayout.findViewById(R.id.btnRegister);
		imvBack = vFragmentLayout.findViewById(R.id.imvBack);
		tvTitle = vFragmentLayout.findViewById(R.id.tvTitle);
		lnMainLoginRegister = vFragmentLayout.findViewById(R.id.lnMainLoginRegister);
		btnLoginFacebook = vFragmentLayout.findViewById(R.id.btnLoginFacebook);
		btnLoginGoogle = vFragmentLayout.findViewById(R.id.btnLoginGoogle);
		lnLoginRegisterButton = vFragmentLayout.findViewById(R.id.lnLoginRegisterButton);
		rlPhoneNumber = vFragmentLayout.findViewById(R.id.rlPhoneNumber);

		lnMainLoginRegister.setBackgroundResource(R.drawable.list_background_mountain);
		animationDrawable = (AnimationDrawable) lnMainLoginRegister.getBackground();
		lnMainLoginRegister.setBackgroundDrawable(animationDrawable);
		animationDrawable.setExitFadeDuration(2000);
		animationDrawable.start();


		tvDate.setOnClickListener(this);
		btnRegister.setOnClickListener(this);
		btnLogin.setOnClickListener(this);
		tvForgetPassword.setOnClickListener(this);
		imvBack.setOnClickListener(this);

	}

	private void googleSignIn() {
		GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
		googleSignInClient = GoogleSignIn.getClient(getContext(), gso);
		btnLoginGoogle.setOnClickListener(this);
	}

	private void facebookSignIn() {
		callbackManager = CallbackManager.Factory.create();
		checkLoginStatus();

		btnLoginFacebook.setOnClickListener(this);
		LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {

			}

			@Override
			public void onCancel() {

			}

			@Override
			public void onError(FacebookException error) {

			}
		});

	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btnLogin: {
				if (!typeLogin){
					if (validateForm()) {
						presenter.login(email,password);
					}
				}else {
					if (validateForm()){
						presenter.register(email,password,fullName,date,phonenumber,"",address,sex);
					}
				}
//				checkingLogin();
				break;
			}
			case R.id.btnRegister: {
				typeLogin = true;
				checkingLogin();
				break;
			}
			case R.id.tvForgetPassword: {
				break;
			}
			case R.id.tvDate: {
				final Calendar calendar = Calendar.getInstance();
				final int day = calendar.get(Calendar.DAY_OF_MONTH);
				int month = calendar.get(Calendar.MONTH);
				int year = calendar.get(Calendar.YEAR);
				DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
					@Override
					public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
						if (year < currentTime.get(Calendar.YEAR)) {
							if (currentTime.get(Calendar.YEAR) - year > 5) {
								tvDate.setText(dayOfMonth + "/" + month+1 + "/" + year);
								tvDate.setTextColor(Color.WHITE);
							}
						} else {
							tvDate.setText("date is to be more than 5 year old");
							tvDate.setTextColor(Color.RED);
						}
					}
				}, year, month, day);
				datePickerDialog.show();
				datePickerDialog.getDatePicker().setMaxDate(currentTime.getTimeInMillis());
				break;
			}
			case R.id.imvBack: {
				typeLogin = false;
				checkingLogin();
				break;
			}
			case R.id.btnLoginFacebook: {
				LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email", "public_profile"));
				break;
			}
			case R.id.btnLoginGoogle: {
				Intent signIntent = googleSignInClient.getSignInIntent();
				startActivityForResult(signIntent, RC_SIGN_IN);
				break;
			}

		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		callbackManager.onActivityResult(requestCode, resultCode, data);
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == RC_SIGN_IN) {
			Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
			try {
				GoogleSignInAccount account = task.getResult(ApiException.class);
				//TODO go to back to app

			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
	}

	AccessTokenTracker tokenTracker = new AccessTokenTracker() {
		@Override
		protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
			if (currentAccessToken == null) {
				Toast.makeText(activity, "User Logged out", Toast.LENGTH_LONG).show();
			}
			else
				loadUserProfile(currentAccessToken);
		}
	};

	private void loadUserProfile(AccessToken newAccessToken) {
		GraphRequest request = GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
			@Override
			public void onCompleted(JSONObject object, GraphResponse response) {
				try {
					String first_name = object.getString("first_name");
					String last_name = object.getString("last_name");
					String email = object.getString("email");
					String id = object.getString("id");
					image_url= "https://graph.facebook.com/" + id + "/picture?type=normal";

					RequestOptions requestOptions = new RequestOptions();
					requestOptions.dontAnimate();

//					Glide.with(getContext()).load(image_url).into(testFacebook);

				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		});

		Bundle parameters = new Bundle();
		parameters.putString("fields", "first_name,last_name,email,id");
		request.setParameters(parameters);
		request.executeAsync();

	}

	private void checkLoginStatus() {
		if (AccessToken.getCurrentAccessToken() != null) {
			loadUserProfile(AccessToken.getCurrentAccessToken());
		}
	}

	private Boolean validateForm() {
		if (typeLogin) {
			 email = edtEmail.getText().toString().trim();
			 password = edtPassword.getText().toString().trim();
			 fullName = edtFullName.getText().toString().trim();
			 address = edtAddress.getText().toString().trim();
			 phonenumber = edtPhoneNumber.getText().toString().trim();
			 date = tvDate.getText().toString().trim();
			 sex = false;
			//email
			if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
				edtEmail.setError("This email not exits");
			}

			//password
			if (!PASSWORD.matcher(password).matches()) {
				edtPassword.setError("This password need 1 special character and 1 number and more than 8 character 1 uperkey ");
			}else if (password.isEmpty()){
				edtPassword.setError("password can't be emty");
			}else {
				//TODO remember to add +84
//				passwordFinal = passwordMd5(password);
			}

			//sex
			if (rbFemail.isChecked()){
				sex = false;
			}else {
				sex = true;
			}

			//full name
			if (fullName.isEmpty()){
				edtFullName.setError("fullname can't be emty");
			}

			//address
			if (address.isEmpty()){
				edtAddress.setError("address can't be emty");
			}

			//phonenumber
			if (!PHONENUMBER.matcher(phonenumber).matches()){
				edtPhoneNumber.setError("not a phonenumber");
			}else if (phonenumber.isEmpty()){
				edtPhoneNumber.setError("phonenumber can't be empty");
			}

			//date
			if (date.equalsIgnoreCase("Date")||date.equalsIgnoreCase("date is to be more than 5 year old")) {
				tvDate.setText("please check your date");
				tvDate.setTextColor(Color.RED);
			}

			if (!date.equalsIgnoreCase("Date")
					&&!date.equalsIgnoreCase("date is to be more than 5 year old")
					&&Patterns.EMAIL_ADDRESS.matcher(email).matches()
					&&PASSWORD.matcher(password).matches()
					&&!password.isEmpty()
					&&!fullName.isEmpty()
					&&!address.isEmpty()
					&&PHONENUMBER.matcher(phonenumber).matches()
					&&!phonenumber.isEmpty()){

				return true;
			}
			return false;
		} else {
			edtEmail.setError(null);
			edtPassword.setError(null);
			email = edtEmail.getText().toString().trim();
			password = edtPassword.getText().toString().trim();

			if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
				edtEmail.setError("This email not exits");
			}else if (email.isEmpty()){
				edtEmail.setError("email can't be emty");
			}

			if (password.isEmpty()) {
				edtPassword.setError("password is emty");
			}

			if (!email.isEmpty()&&!password.isEmpty()&&Patterns.EMAIL_ADDRESS.matcher(email).matches()){

				return true;
			}
			return false;
		}
	}

//	private String passwordMd5(String password){
//		String finalPassword = "";
//		try {
//			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//
//			messageDigest.update(password.getBytes());
//
//			byte[] bytes = messageDigest.digest();
//
//			StringBuilder sb = new StringBuilder();
//
//			for (int i = 0; i < bytes.length; i++) {
//				sb.append(Integer.toString((bytes[i]&0xff)+0x100,16).substring(1));
//			}
//
//			return  finalPassword = sb.toString();
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	private void checkingLogin() {
		rlPhoneNumber.setVisibility(View.GONE);
		tvTitle.setVisibility(View.GONE);
		edtEmail.setVisibility(View.INVISIBLE);
		edtPassword.setVisibility(View.INVISIBLE);
		imvBack.setVisibility(View.GONE);
		edtFullName.setVisibility(View.GONE);
		lnDate.setVisibility(View.GONE);
		rlPhoneNumber.setVisibility(View.GONE);
		edtAddress.setVisibility(View.GONE);
		rgSex.setVisibility(View.GONE);
		btnRegister.setVisibility(View.GONE);
		tvForgetPassword.setVisibility(View.GONE);

		tvTitle.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		edtEmail.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		edtPassword.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		edtFullName.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		lnDate.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		rlPhoneNumber.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		edtAddress.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		rgSex.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();
		tvForgetPassword.animate().translationX(Resources.getSystem().getDisplayMetrics().widthPixels).setDuration(0).start();

		lnLoginRegisterButton.animate().translationY(Resources.getSystem().getDisplayMetrics().heightPixels).setDuration(0).start();
		btnLoginGoogle.animate().translationY(Resources.getSystem().getDisplayMetrics().heightPixels).setDuration(0).start();
		btnLoginFacebook.animate().translationY(Resources.getSystem().getDisplayMetrics().heightPixels).setDuration(0).start();
		if (typeLogin) {
			tvTitle.setText("Sign up");


			imvBack.animate().translationX(0.0f).setDuration(1000).start();
			tvTitle.animate().translationX(0.0f).setDuration(1000).start();
			edtEmail.animate().translationX(0.0f).setDuration(1000).start();
			edtPassword.animate().translationX(0.0f).setDuration(1000).start();
			edtFullName.animate().translationX(0.0f).setDuration(1000).start();
			lnDate.animate().translationX(0.0f).setDuration(1000).start();
			rlPhoneNumber.animate().translationX(0.0f).setDuration(1000).start();
			edtAddress.animate().translationX(0.0f).setDuration(1000).start();
			rgSex.animate().translationX(0.0f).setDuration(1000).start();
			lnLoginRegisterButton.animate().translationY(0.0f).setDuration(1000).start();

			tvTitle.setVisibility(View.VISIBLE);
			imvBack.setVisibility(View.VISIBLE);
			edtEmail.setVisibility(View.VISIBLE);
			edtPassword.setVisibility(View.VISIBLE);
			edtFullName.setVisibility(View.VISIBLE);
			lnDate.setVisibility(View.VISIBLE);
			rlPhoneNumber.setVisibility(View.VISIBLE);
			edtAddress.setVisibility(View.VISIBLE);
			rgSex.setVisibility(View.VISIBLE);
			tvForgetPassword.setVisibility(View.GONE);
			btnRegister.setVisibility(View.GONE);

		} else {
			tvTitle.setText("Login");

			tvTitle.animate().translationX(0.0f).setDuration(1000).start();
			edtEmail.animate().translationX(0.0f).setDuration(1000).start();
			edtPassword.animate().translationX(0.0f).setDuration(1000).start();
			lnLoginRegisterButton.animate().translationY(0.0f).setDuration(1000).start();
			btnLoginGoogle.animate().translationY(0.0f).setDuration(1000).start();
			btnLoginFacebook.animate().translationY(0.0f).setDuration(1000).start();
			tvForgetPassword.animate().translationX(0.0f).setDuration(1000).start();

			tvTitle.setVisibility(View.VISIBLE);
			edtEmail.setVisibility(View.VISIBLE);
			edtPassword.setVisibility(View.VISIBLE);
			lnLoginRegisterButton.setVisibility(View.VISIBLE);
			imvBack.setVisibility(View.GONE);
			edtFullName.setVisibility(View.GONE);
			lnDate.setVisibility(View.GONE);
			rlPhoneNumber.setVisibility(View.GONE);
			edtAddress.setVisibility(View.GONE);
			rgSex.setVisibility(View.GONE);
			btnRegister.setVisibility(View.VISIBLE);
			tvForgetPassword.setVisibility(View.VISIBLE);

		}
	}
	
}
