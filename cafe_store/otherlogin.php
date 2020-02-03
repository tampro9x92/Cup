<?php
    include "connection.php";
    $id_user =  $_POST['id_user'];
   
    if(!checkOtherLoginId($conn,$id_user)){
        $sql = "INSERT INTO `other_user` (`id_user`) VALUES ('$id_user')";
        $query =  $conn->query($sql);
        if($query){
            $appDataGetBack['total'] = "0";
            $appDataGetBack['message']= "Sign In Success";
            $appDataGetBack['code'] = "200";
            header('HTTP/1.1 200 register Success');
        
        }else{
            $appDataGetBack['total'] = "0";
            $appDataGetBack['message']= "Sign In fail";
            $appDataGetBack['code'] = "401";
            
            header('HTTP/1.1 401 register fail');
        }
      
    }else{
        $appDataGetBack['total'] = "0";
        $appDataGetBack['message']= "alreadty exit";
        $appDataGetBack['code'] = "200";        
    }
    echo json_encode($appDataGetBack);

    function checkOtherLoginId($conn,$id_user){
        $sql = "SELECT * FROM `other_user` WHERE `id_user` = '$id_user'";
        $query = $conn->query($sql);
        $row = $query->fetch_array();
        if($row){
           $data = array(
               'id_user'=>$row['id_user']
           );
        }else{
            $data = array();
        }
        if(sizeof($data)>0){
            return true;
        }
        return false;
    }
?>