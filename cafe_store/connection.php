<?php
	$severname = "localhost";
	$username = "root";
	$password = "";
	$data_base_name = "cafe_store";
	$conn = mysqli_connect ($severname,$username,$password,$data_base_name);

	mysqli_set_charset($conn,"utf-8");

	$appDataGetBack = [
		'total'=>"",
		'message'=>"",
		'code'=>"",
		'data'=>""
	];
?>