<?php
 
 $filename1="data.txt";
 if ( filesize($filename1)==0) {
    file_put_contents($filename1,"$000006666*");
 }
 
 if (!empty($_POST["informa"])) {
	$msg2=file_get_contents($filename1);
	$arr1 = str_split($msg2);
	$sstr = $_POST["informa"];
	if ($sstr == "0a1") {
		$arr1[1]='0';
	}
	else if ($sstr == "0b1") {
		$arr1[1]='1';
	}
	else if ($sstr == "0c1") {
		$arr1[2]='0';
	}
	else if ($sstr == "0d1") {
		$arr1[2]='1';
	}
	else if ($sstr == "0e1") {
		$arr1[3]='0';
	}
	else if ($sstr == "0f1") {
		$arr1[3]='1';
	}
	else if ($sstr == "0g1") {
		$arr1[4]='0';
	}
	else if ($sstr == "0h1") {
		$arr1[4]='1';
	}
	else if ($sstr == "0i1") {
		$arr1[5]='0';
	}
	else if ($sstr == "0j1") {
		$arr1[5]='1';
	}
	
	else if ($sstr == "0k1") {
		$arr1[6]='0';
	}
	else if ($sstr == "0l1") {
		$arr1[6]='1';
	}
	else if ($sstr == "0m1") {
		$arr1[6]='2';
	}
	else if ($sstr == "0n1") {
		$arr1[6]='3';
	}
	else if ($sstr == "0o1") {
		$arr1[6]='4';
	}
	else if ($sstr == "0p1") {
		$arr1[6]='5';
	}
	else if ($sstr == "0q1") {
		$arr1[6]='6';
	}
	
	else if ($sstr == "0r1") {
		$arr1[7]='0';
	}
	else if ($sstr == "0s1") {
		$arr1[7]='1';
	}
	else if ($sstr == "0t1") {
		$arr1[7]='2';
	}
	else if ($sstr == "0u1") {
		$arr1[7]='3';
	}
	else if ($sstr == "0v1") {
		$arr1[7]='4';
	}
	else if ($sstr == "0w1") {
		$arr1[7]='5';
	}
	else if ($sstr == "0x1") {
		$arr1[7]='6';
	}
	
	else if ($sstr == "0A1") {
		$arr1[8]='0';
	}
	else if ($sstr == "0B1") {
		$arr1[8]='1';
	}
	else if ($sstr == "0C1") {
		$arr1[8]='2';
	}
	else if ($sstr == "0D1") {
		$arr1[8]='3';
	}
	else if ($sstr == "0E1") {
		$arr1[8]='4';
	}
	else if ($sstr == "0F1") {
		$arr1[8]='5';
	}
	else if ($sstr == "0G1") {
		$arr1[8]='6';
	}
	
	else if ($sstr == "0H1") {
		$arr1[9]='0';
	}
	else if ($sstr == "0I1") {
		$arr1[9]='1';
	}
	else if ($sstr == "0J1") {
		$arr1[9]='2';
	}
	else if ($sstr == "0K1") {
		$arr1[9]='3';
	}
	else if ($sstr == "0L1") {
		$arr1[9]='4';
	}
	else if ($sstr == "0M1") {
		$arr1[9]='5';
	}
	else if ($sstr == "0N1") {
		$arr1[9]='6';	
	}
	
	$final_string = implode("",$arr1);
	file_put_contents($filename1,$final_string);
 }     
 $msg=file_get_contents($filename1);
 echo $msg;
 
 ?>
  