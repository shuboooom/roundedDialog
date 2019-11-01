# Library to show a rounded dialog instead of a default one.

## How to use

### One-step install

Add the following dependency to your build.gradle:
```gradle
dependencies {
   implementation 'com.github.shuboooom:pingMeLive:1.0'
}
```

### How to use

```java

Button open = findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new roundedDialog.Builder(MainActivity.this)
                        .setTitle("Dialog")
                        .setMessage("This is a rounded dialog")
                        .setDoneText("Awesome Dialog")
                        .setCancelText("Cancel")
                        .setOnClick(new roundedDialog.onClick() {
                            @Override
                            public void onDone(Dialog dialog) {
    
                            
                            }

                            @Override
                            public void onCancel(Dialog dialog) {

                            }
                        })
                        .show();

            }
        });

```
