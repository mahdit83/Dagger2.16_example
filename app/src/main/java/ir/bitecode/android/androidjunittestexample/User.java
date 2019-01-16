package ir.bitecode.android.androidjunittestexample;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class User implements Parcelable {

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
    private String name;
    private int age;
    private List<String> numbers ;
    private List<User> family;


    public User(String name, int age, List<String> numbers, List<User> family) {
        this.name = name;
        this.age = age;
        this.numbers = numbers;
        this.family = family;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeStringList(numbers);

        dest.writeInt(null == family ? -1 : family.size());
        if (family != null && family.size() > 0) {
            for (User user : family) {
                dest.writeParcelable(user ,flags);
            }
        }
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        return ((User) obj).getName().equals(name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
        numbers = in.createStringArrayList();

        int count = in.readInt();
        if (count >= 0) {
            family = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                family.add((User) in.readParcelable(User.class
                        .getClassLoader()));
            }
        }
    }
}
