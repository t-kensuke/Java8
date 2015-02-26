
function createLoggingArrayList() {
	var arr = new (Java.extend(java.util.ArrayList)){
		add: function(x) {
			print("Adding " + x);
			return Java.super(arr).add(x);
		}
	}
	return arr;
}

var list = createLoggingArrayList();
list.add("a");
print(list);

var list2 = createLoggingArrayList();
list2.add("b");
print(list2);
