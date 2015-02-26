var arg;
if(arguments[0] != null){
	arg = arguments[0];
}
if(arg == null){
	var arg = $ENV.ARG;
}
if(arg == null){
	print("Please enter your age: ");
	var arg = readLine();
}
print("You will be " + arg + " years old.");
