# java-wget

This is a simplified wget implementation in Java.

### Usage

Just call any of the `get()` functions from the `Wget` class.
```
	public static void main(String[] args) {
		Wget.wGet("thefile.zip", "http://example.com/downloads/thefile.zip");
	}
```

### Progress Viewing

The amount of bytes transferred can be viewed by calling the `progress()`.