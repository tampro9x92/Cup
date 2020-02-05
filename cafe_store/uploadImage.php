<?php
	$linkDataBase = "http://192.168.1.217/cafestore/";
	$file_path = "Image/";
	$file_path = $file_path.time()."-".basename($_FILES["image"]["name"]);
	$uploadOk = 1;
    $imageFileType = strtolower(pathinfo($file_path,PATHINFO_EXTENSION));
    $error = "";
	$checkUploadFile = false;
	$check =getimagesize($_FILES["image"]["tmp_name"]);
	if ($check !=false) {
		$uploadOk=1;
	}else {
		$uploadOk =0;
		$appDataGetBack['total']="0";
        $appDataGetBack['message']="upload file not a valid image";
        $appDataGetBack["code"]="402";
		$appDataGetBack['data']=null;
	};

	if ($imageFileType != "jpg" && $imageFileType != "png"&& $imageFileType !="jpeg" &&$imageFileType !="gif") {
		$uploadOk = 0;
		$checkUploadFile = false;
	}else {
		$uploadOk = 1;
		$checkUploadFile = false;
	};
	if ($uploadOk == 0) {
        $error="image type is not supported";
		$checkUploadFile = false;
	}else{
		if (move_uploaded_file($_FILES["image"]["tmp_name"],$file_path)) {
           	$error="image upload success full";
			$checkUploadFile = true;
		}else{
            $error="image upload fail full";
			$checkUploadFile = false;
		}
	}
?>