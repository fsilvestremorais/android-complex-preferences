Complex Preferences Android - by Felipe Silvestre
===========================

Complex Preferences is a component to android that allows the developers put objects and complex objects in SharedPreferences.
Gson (Google Json Library) is used internally to persist objects.

SharedPrefences of android is limited, only accept theses types: int,float,long,boolean,String,Set String. ComplexPrefences comes to improve it.

How to use:

You can persist your models with ComplexPreferences.
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

License
-------
    Copyright Felipe Silvestre.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
