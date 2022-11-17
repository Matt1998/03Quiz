<?php
session_start();
    if(isset($_POST['submit'])){
        if((isset($_POST['password']) && $_POST['password'] != '')){
            // User Input
           $password = $_POST['password'];

            $errorMsg = checkPassword($password);
        }
    }
    function checkPassword($password){
    	$filename = "top-1000.txt";
	$lines = explode("\n", file_get_contents($filename));
	foreach ($lines as $value) {
		if (str_contains($password, $value)) {
		header("location: index.php");
	}
    }

    if(strlen($password) <= 10){
	header("location: index.php");
	die();
    }else{
	$_SESSION['password'] = $password;
	header("location: welcome.php");
    }
}
?>
<head>
<title>Test</title>
</head>

<body>
<form action="<?php echo $_SERVER['PHP_SELF']?>" method="post">
	<label for="password">Password</label>
	<input type="password" id="password" name="password" />
	<input type="submit" name="submit" />
</form>
<p><?php echo $errorMsg; ?></p>
</body>
