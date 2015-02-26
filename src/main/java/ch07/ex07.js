ProcessBuilder = java.lang.ProcessBuilder
BufferedReader = java.io.BufferedReader;
InputStreamReader =  java.io.InputStreamReader;

function pipe() {
	if(arguments == null || arguments.length == 0){
		return;
	}
	var arg = new Array();
	arg.push("cmd");
	arg.push("/c");
	for(var i=0; i<arguments.length; i++){
		arg.push(arguments[i]);
	}
	var pb = new ProcessBuilder(arg);
	var process = pb.start();
	var ret = process.waitFor();
	print("戻り値：" + ret);
	printInputStream( process.getInputStream());
}

function printInputStream()  {
	var br = new BufferedReader(new InputStreamReader(arguments[0]));
	try {
		for (;;) {
			var line = br.readLine();
			if (line == null) break;
			print(line);
		}
	} finally {
		br.close();
	}
}

pipe('ping|find "a"');

