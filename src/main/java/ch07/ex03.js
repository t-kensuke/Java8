var b = new java.math.BigInteger('1234567890987654321');
print(b);
b.mod(java.math.BigInteger.TEN);
var s = java.lang.String.format("%d", b);
print(s);