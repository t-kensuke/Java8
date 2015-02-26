var contents = new java.lang.String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(new java.io.File(".\\src\\test\\resources\\ch07\\ex10.txt").getPath())), java.nio.charset.StandardCharsets.UTF_8);
var stream = java.util.Arrays.stream(Java.to(contents.split(/\r\n/), "java.lang.String[]"))
stream.forEach(function(i) {
	var data = Java.to(i.split(/:/), "java.lang.String[]")
	if(data.length == 2){
		print(">>> " + data[0] + " =>" + data[1]);
	}
});

