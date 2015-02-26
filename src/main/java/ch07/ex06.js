function pipe() {
	if(arguments == null || arguments.length == 0){
		return;
	}
	var result = $EXEC(arguments[0]);

	for (i = 1; i < arguments.length; i++) {
	  result = $EXEC(arguments[i], result);
	}
	print(result);
}
pipe('ping', 'find "a"');
pipe('ping');
