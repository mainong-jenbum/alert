# Alert

*Show alerts in a new way* \
A simple library to display alert dialogs in multiple ways.

## How to

1. Add the JitPack repository to your build file.\
*Add it in your root build.gradle at the end of repositories*


```gradle
allprojects {
   repositories {
        ...
	    maven { url 'https://jitpack.io' }
   }
}
```

2. Add the dependency

```gradle
dependencies {
	implementation 'com.github.mainong-jenbum:alert:v2.0.0'
}

```

## Usage

### Success
![success_dialog](https://user-images.githubusercontent.com/23124053/58652792-fba45d80-8331-11e9-854f-7429bae04196.png)
```java
Alert.success(this,"Success", "This is a success alert dialog");
```

### Info
![info_dialog](https://user-images.githubusercontent.com/23124053/58652791-fb0bc700-8331-11e9-822c-c342368567a3.png)
```java
Alert.info(this,"Info", "This is an info alert dialog");
```

### Warning
![warning_dialog](https://user-images.githubusercontent.com/23124053/58652796-fcd58a80-8331-11e9-920c-a77aeba53af0.png)
```java
Alert.warn(this,"Warning", "This is a warning alert dialog");
```

### Error
![error_dialog](https://user-images.githubusercontent.com/23124053/58652789-f9da9a00-8331-11e9-95d8-1a37e6f4adf6.png)
```java
Alert.error(this,"Error", "This is an error alert dialog");
```

### Confirm
![confirm_dialog](https://user-images.githubusercontent.com/23124053/58652782-f8a96d00-8331-11e9-9bc6-9665a43304ec.png)
```java
Alert.confirm(this, "Confirm", "This is a confirmation dialog")
                .setOnAlertListener(new AlertListener() {
                    @Override
                    public void confirm() {
		    
		    // POP libray to display toast messages
                        Pop.success(MainActivity.this, "Confirm Dialog");
                    }
                })
                .show();
```
