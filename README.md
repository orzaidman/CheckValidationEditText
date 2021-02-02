# CheckValidationEditText
[![](https://jitpack.io/v/orzaidman/CheckValidationEditText.svg)](https://jitpack.io/#orzaidman/CheckValidationEditText)


Step 1. Add the JitPack repository to your build file.
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.orzaidman:CheckValidationEditText:Tag'
	}



Usage
```
All opthions:
    public enum Type {NUMBERS, MAIL, SMALL_LETTERS, CAPITAL_LETTERS, PHONE_NUMBER_ISRAEL, PHONE_NUMBER, AGE, LETTERS, DATE}


private EditText main_EDIT_name;
private EditText main_EDIT_phone;
private CheckEditText form;
private Button check;

//find views:
  main_EDIT_name = findViewById(R.id.main_EDIT_name);
  btn = findViewById(R.id.btn);
  main_EDIT_phone = findViewById(R.id.main_EDIT_phone);
  
  form = new CheckEditText();
        form.add(main_EDIT_name, CheckEditText.Type.SMALL_LETTERS); // add all your Edit Texts
        form.add(main_EDIT_phone, CheckEditText.Type.PHONE_NUMBER);

// Check the form
  check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String result  =  form.checkForm()+"";
                    }
                }
        );

```
