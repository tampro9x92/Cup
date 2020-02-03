<?php
 include "connection.php";
 $email = $_POST['email'];
 $passwordIn = $_POST['password'];
 $passwordOut = md5($passwordIn);
 
 $sql = "SELECT * FROM `user` WHERE password = '$passwordOut' AND email = '$email'";
 $query = $conn->query($sql);
 $row = $query->fetch_array();
     if($row){
         $data = array(
             'id'=>$row['id'],
             'email'=>$row['email'],
             'password'=>$row['password'],
             'fullname'=>$row['fullname'],
             'dateofbirth'=>$row['dateofbirth'],
             'permission'=>$row['permission'],
             'phonenumber'=>$row['phonenumber'],
             'avatar'=>$row['avatar'],
             'address'=>$row['address'],
             'sex'=>$row['sex']
         );

            $appDataGetBack['total'] = "0";
            $appDataGetBack['message']= "Login Success";
            $appDataGetBack['code'] = "200";
            $appDataGetBack['data'] = array($data); 
       
     }else{
        $appDataGetBack['total'] = "0";
        $appDataGetBack['message']= "Login fail";
        $appDataGetBack['code'] = "401";
        $appDataGetBack['data'] = array(null);
        // header('HTTP/1.1 401 Login Fail');
     }
     echo json_encode($appDataGetBack);
?>