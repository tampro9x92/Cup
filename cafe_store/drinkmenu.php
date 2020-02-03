<?php
    include "connection.php";
    $sql = "SELECT * FROM `product`";
    $query = $conn->query($sql);
  
    $arr = array();
    while($row = $query->fetch_array()){
        $arr[] =array(
            'id'=>$row['id'],
            'name'=>$row['name'],
            'avatar'=>$row['avatar'],
            'price'=>$row['price'],
            'status'=>$row['status'],);
    };
    if(sizeof($arr)>0){
        $appDataGetBack['total'] = "0";
        $appDataGetBack['message']= "Success";
        $appDataGetBack['code'] = "200";
        $appDataGetBack['data'] =$arr; 
    }else{
        $appDataGetBack['total'] = "0";
        $appDataGetBack['message']= "Fail";
        $appDataGetBack['code'] = "401";
        $appDataGetBack['data'] = null; 
    }   
    
    echo json_encode($appDataGetBack);
?>