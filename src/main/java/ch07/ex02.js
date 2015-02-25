var contents = new java.lang.String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(new java.io.File(".\\src\\test\\resources\\ch07\\ex02.txt").getPath())), java.nio.charset.StandardCharsets.UTF_8);
var stream = java.util.Arrays.stream(Java.to(contents.split(/\W+/), "java.lang.String[]"))
var result = stream.filter(function(i) {
  return i.length() >=12 ;
}).distinct().sorted()

result.forEach(function(i) {
  print(">>> " + i);
});

