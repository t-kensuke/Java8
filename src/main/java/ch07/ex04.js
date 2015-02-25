var s = "test";
print(s.getClass()) // class java.lang.Stringが表示される
print(java.lang.String.class.cast(s));  // testが表示される(java.lang.Stringとして処理された)
