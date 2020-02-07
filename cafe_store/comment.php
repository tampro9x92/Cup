<?php
    include 'connection.php';
    $rate = $_POST['rate'];
    $comment = $_POST['comment'];
    $date = $_POST['comment'];
    $id_user = $_POST['id_user'];
    $id_drink = $_POST['id_drink'];
    if($rate!=null){
        $sql = "INSERT INTO `comment`(`rate`, `comment`, `date`, `id_drink`, `id_user`) VALUES ('$rate','$comment','$date','$id_drink','$id_user')";
        $query = $conn->query($sql);
        if($query){
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="comment success";
            $appDataGetBack["code"]="200";
			$appDataGetBack['data']=null;
        }else{
            $appDataGetBack['total']="0";
            $appDataGetBack['message']="comment fail";
            $appDataGetBack["code"]="401";
			$appDataGetBack['data']=null;
        }
    }
    if($rate==null&&$id_user!=null&&$id_drink!=null){
        $sql = "SELECT * FROM `comment` WHERE `id_drink`='$id_drink' AND `id_user`='$id_user'";
        $query = $conn->query($sql);
        $arr = array();
        if($query){
            while($row = $query->fetch_array()){
                $arr[]=array(
                    'id'=>$row['id'],
                    'rate'=>$row['rate'],
                    'comment'=>$row['comment'],
                    'date'=>$row['date']
                );
                $appDataGetBack['total']=sizeof($arr);
                $appDataGetBack['message']="get comment success";
                $appDataGetBack["code"]="200";
                $appDataGetBack['data']=$arr;
            }
        }else{
            $appDataGetBack['total']=sizeof($arr);
            $appDataGetBack['message']="get comment fail";
            $appDataGetBack["code"]="200";
			$appDataGetBack['data']=$arr;
        }
    }
?>