Complex Preferences Android - by Felipe Silvestre
===========================

Complex Preferences is a component to android that allows the developers put objects and complex objects in SharedPreferences.
Gson (Google Json Library) is used internally to persist objects.

How to use:

You can persist your models with ComplexPreferences
```java
    User user = new User();
    user.setName("Felipe");
    user.setAge(22); 
    user.setActive(true); 

    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);;
  	complexPreferences.putObject("user", user);
	  complexPreferences.commit();
```

And you can get it when you need!

```java
    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);
  	User user = complexPreferences.getObject("user", User.class);
```

Simple and effective.

If you need persist complex objects like a List of Users, you need create a new Class with List or other structure that you want.

```java
    public class ListComplexObject {
      
    	List<User> users;    

    	public List<User> getUsers() {
    		return users;
    	}    
    	public void setUsers(List<User> users) {
    		this.users = users;
    	}
    }
```

And use this object to persist

```java
    List<User> users = new ArrayList<User>();
    // populate your List
    ListComplexObject complexObject = new ListComplexObject();
  	complexObject.setUsers(users);    

    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);;
  	complexPreferences.putObject("list", complexObject);
	  complexPreferences.commit();
```

Get your complex object

```java
    ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(this, "mypref", MODE_PRIVATE);
  	ListComplexObject complexObject = complexPreferences.getObject("list", ListComplexObject.class);

		for(User item: complexObject.users){
			Log.i("ComplexPreferences", "item " + item);
		}
```

Good work!
