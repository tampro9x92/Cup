<?php
    include 'connection.php';
    include 'uploadImage.php';
    $id = $_POST['id'];
    $sql = "INSERT INTO `image` ( `image`, `id_user`, `id_product`) VALUES ('$file_path','$id',1)";
    $query = $conn->query($sql);
    if($check){
        $appDataGetBack['total']="0";
        $appDataGetBack['message'] = "upload product image success";
        $appDataGetBack['code']="200";
        $appDataGetBack['data']=null;    
    }else{
        $appDataGetBack['total']="0";
        $appDataGetBack['message'] = "upload image fail";
        $appDataGetBack['code']="200";
        $appDataGetBack['data']=null; 
    }
    echo json_encode($appDataGetBack);
?>