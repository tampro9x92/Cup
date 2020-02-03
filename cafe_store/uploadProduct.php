<?php
    include 'connection.php';
    $name = $_POST['name'];
    $price = $_POST['price'];
    $status = $_POST['status'];
    $id_category = $_POST['id_category'];
    $sql = "INSERT INTO `product` ( `name`, `price`, `status`, `id_category`) VALUES ('$name','$price','$status','$id_category')";
    
    $query = $conn->query($sql);
    
    if($query){
        $appDataGetBack['total']="0";
        $appDataGetBack['message']="insert success";
        $appDataGetBack['code']="200";
        $appDataGetBack['data']=null;
    }else{
        $appDataGetBack['total']="0";
        $appDataGetBack['message']="insert fail";
        $appDataGetBack['code']="400";
        $appDataGetBack['data']=null;
    }

?>