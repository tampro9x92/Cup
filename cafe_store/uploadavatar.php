<?php
    include 'connection.php';
    include 'uploadImage.php';
    $id = $_POST['id'];
    $sql = "INSERT INTO `image` ( `image`, `id_user`, `id_product`) VALUES ('$file_path','$id',2)";
    if($checkUploadFile){
        $query = $conn->query($sql);
        if($query){
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="upload avatar success";
            $appDataGetBack['code']="200";
            $appDataGetBack['data']=null;
        }else{
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="upload avatar success";
            $appDataGetBack['code']="401";
            $appDataGetBack['data']=null;
        }
    }
    echo json_encode($appDataGetBack);
?>