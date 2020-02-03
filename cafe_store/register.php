
<?php
    include "connection.php";
    $email = $_POST['email'];
    $passwordIn = $_POST['password'];
    $passwordOut = md5($passwordIn);
    
    $fullname = $_POST['fullname'];
    $dateofbirth = $_POST['dateofbirth'];
    $permission = $_POST['permission'];
    $phonenumber = $_POST['phonenumber'];
    $address = $_POST['address'];
    $sex = $_POST['sex'];
    $avatar = $_POST['avatar'];
    $passwordOut = md5($passwordIn);
    $sql;
   
        if(!checkEmail($email,$conn)&&!checkPhoneNumber($phonenumber,$conn)){        
             $sql = "INSERT INTO 
            `user` (`email`, `password`, `fullname`, `dateofbirth`, `permission`, `phonenumber`, `avatar`,`address`, `sex`)
            VALUES('$email','$passwordOut','$fullname','$dateofbirth','$permission','$phonenumber','$avatar','$address','$sex')";
            $query =  $conn->query($sql);
            
            if ($query) {
                $appDataGetBack['total'] = "0";
                $appDataGetBack['message']= "Sign In Success";
                $appDataGetBack['code'] = "200";
            
                // header('HTTP/1.1 200 Register success');
            }else {
                $appDataGetBack['total'] = "0";
                $appDataGetBack['message']= "Sign In fail";
                $appDataGetBack['code'] = "401";
            
                header('HTTP/1.1 401 register fail');
            }
            echo json_encode($appDataGetBack);
        }else if(checkEmail($email,$conn)){
                $appDataGetBack['total'] = "0";
                $appDataGetBack['message']= "Email already exist";
                $appDataGetBack['code'] = "200";
            
                echo json_encode($appDataGetBack);
        }else if(checkPhoneNumber($phonenumber,$conn)){
            $appDataGetBack['total'] = "0";
            $appDataGetBack['message']= "Phonenumber already exist";
            $appDataGetBack['code'] = "200";
            echo json_encode($appDataGetBack);
        }

    function checkEmail($email,$conn){
          if($email!=null){
            $sql = "SELECT `email` FROM `user` WHERE `email`='$email'";
            $query = $conn->query($sql);
            $row = $query->fetch_array();
            if($row){
                $data = array(
                    'email'=>$row['email']
                );
            }else{
                $data = array();
            }
            if(sizeof($data)>0){
                return true;
            }   
        }
        return false;
    }

    function checkPhoneNumber($phonenumber,$conn){
        if($phonenumber!=null){
            $sql = "SELECT `phonenumber` FROM `user` WHERE `phonenumber`='$phonenumber'";
            $query = $conn->query($sql);
            $row = $query->fetch_array();
            if($row){
                $data = array(
                    'phonenumber'=>$row['phonenumber']
                );
            }else{
                $data = array();
            }
        
            if(sizeof($data)>0){
                return true;
            }
        }
        return false;
    }
?>