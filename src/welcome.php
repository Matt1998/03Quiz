<?php
	session_start();

	if(isset($_POST['submit'])){
		logout();
	}

	function logout(){
		session_destroy();
		header('location:index.php');
		exit;
	}
?>
<!DOCTYPE html>
<html>
<head>
<title>Test Welcome</title>
</head>

<body>
<?php
if(isset($_SESSION['password'])){
	echo "<p>";
	echo "Password: ";
	echo $_SESSION['password'];
	echo "</p>";
	echo '<form action="<?php echo $_SERVER["PHP_SELF"]?>" method="post">';
	echo "<p>";
        echo '<button type="submit" name="submit">Logout</button>';
        echo "</p>";
	echo "</form>"
}
?>
</body>
</html>
