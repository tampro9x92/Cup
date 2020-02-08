<?php
    include 'connection.php';
    $other_id = $_POST['orther_id'];
    $status = $_POST['status'];

    $sql = "SELECT*FROM `iamge` WHERE `other_id`='$other_id' AND `status`='$status'";
    $query = $conn->query($sql);
    $arr = array();
    if($query){
        while($row = $query->fetch_array()){
            $arr[] = array(
                'id'=>$row['id'],
                'avatar'=>$row['avatar']
            );
        }
        $appDataGetBack['total']=sizeof($arr);
        $appDataGetBack['message']="get image success";
        $appDataGetBack["code"]="200";
        $appDataGetBack['data']=$arr;
    }else{
        $appDataGetBack['total']="0";
        $appDataGetBack['message']="get image fail";
        $appDataGetBack["code"]="401";
        $appDataGetBack['data']=$arr;
    }
?>