package Engine.Math.Vector;

public class Vector2i {
    private int x, z;

    public Vector2i(int x, int z){
        this.x = x;
        this.z = z;
    }

    public Vector2i(int u){
        this.x = u;
        this.z = u;
    }

    public void set(int x , int z){
        this.x = x;
        this.z = z;
    }

    public static Vector2i add(Vector2i vector1, Vector2i vector2){
        return new Vector2i(vector1.getX() + vector2.getX(),vector1.getZ() + vector2.getZ());
    }

    public static Vector2i add(Vector2i vector1, int x, int z){
        return new Vector2i(vector1.getX() + x,vector1.getZ() + z);
    }

    public void add(int x, int z){
        this.x += x;
        this.z += z;
    }

    public void add(Vector2i vector){
        this.x += vector.x;
        this.z += vector.z;
    }

    public static Vector2i substract(Vector2i vector1, Vector2i vector2){
        return new Vector2i(vector1.getX() - vector2.getX(),vector1.getZ() - vector2.getZ());
    }

    public static Vector2i multiply(Vector2i vector1, Vector2i vector2){
        return new Vector2i(vector1.getX() * vector2.getX(),vector1.getZ() * vector2.getZ());
    }

    public static Vector2i multiply(int scalar, Vector2i vector){
        return new Vector2i(vector.getX() * scalar,vector.getZ() * scalar);
    }

    public static Vector2i divide(Vector2i vector1, Vector2i vector2){
        return new Vector2i(vector1.getX() / vector2.getX(),vector1.getZ() / vector2.getZ());
    }

    public static int length(Vector2i vector){
        return (int) Math.sqrt(vector.getX() * vector.getX() + vector.getZ() * vector.getZ());
    }

    public static Vector2i normalise(Vector2i vector){
        int len = Vector2i.length(vector);
        return Vector2i.divide(vector,new Vector2i(len,len));
    }

    public static int dot(Vector2i vector1, Vector2i vector2){
        return vector1.getX() * vector2.getX() + vector1.getZ() * vector2.getZ();
    }

    @Override
    public int hashCode() {//changed some code here idk if it works, if you get a mysterious bug, blame this
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + z;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector2i other = (Vector2i) obj;
        if (x != other.x)
            return false;
        if (z != other.z)
            return false;
        return true;
    }

    public static Vector2i empty(){
        return new Vector2i(0,0);
    }

    public String toString(){
        return new String("("+x + ", " + z + ")");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
