<?php
    include 'connection.php';
    include 'uploadImage.php';
    $id = $_POST['id'];
    $sql = "INSERT INTO `image` ( `image`, `id_user`, `id_product`) VALUES ('$file_path','$id',1)";
    $queryUpload = $conn->query($sqlUpload);
    if($checkUploadFile){
        echo json_encode($appDataGetBack);
    }
?>