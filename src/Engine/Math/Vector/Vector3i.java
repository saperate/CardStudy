package Engine.Math.Vector;

public class Vector3i {
    private int x, y, z;

    public Vector3i(int x, int y , int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3i(int u){
        this.x = u;
        this.y = u;
        this.z = u;
    }

    public void set(int x, int y , int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3i add(Vector3i vector1, Vector3i vector2){
        return new Vector3i(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY(),vector1.getZ() + vector2.getZ());
    }

    public static Vector3i add(Vector3i vector1, int x, int y, int z){
        return new Vector3i(vector1.getX() + x, vector1.getY() + y,vector1.getZ() + z);
    }

    public static Vector3i substract(Vector3i vector1, Vector3i vector2){
        return new Vector3i(vector1.getX() - vector2.getX(), vector1.getY() - vector2.getY(),vector1.getZ() - vector2.getZ());
    }

    public static Vector3i multiply(Vector3i vector1, Vector3i vector2){
        return new Vector3i(vector1.getX() * vector2.getX(), vector1.getY() * vector2.getY(),vector1.getZ() * vector2.getZ());
    }

    public static Vector3i multiply(int scalar, Vector3i vector){
        return new Vector3i(vector.getX() * scalar, vector.getY() * scalar,vector.getZ() * scalar);
    }

    public static Vector3i divide(Vector3i vector1, Vector3i vector2){
        return new Vector3i(vector1.getX() / vector2.getX(), vector1.getY() / vector2.getY(),vector1.getZ() / vector2.getZ());
    }

    public static int length(Vector3i vector){
        return (int) Math.sqrt(vector.getX() * vector.getX() + vector.getY() * vector.getY() + vector.getZ() * vector.getZ());
    }

    public static float distance(Vector3i v0, Vector3i v1){
        return (float) (Math.sqrt( (v0.x - v1.x)*(v0.x - v1.x) + (v0.y - v1.y)*(v0.y - v1.y) + (v0.z - v1.z)*(v0.z - v1.z)));
    }

    public static Vector3i normalise(Vector3i vector){
        int len = Vector3i.length(vector);
        return Vector3i.divide(vector,new Vector3i(len,len,len));
    }

    public static int dot(Vector3i vector1, Vector3i vector2){
        return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY() + vector1.getZ() * vector2.getZ();
    }

    @Override
    public int hashCode() {//changed some code here I do not know if it works nor do i know what it does
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
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
        Vector3i other = (Vector3i) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (z != other.z)
            return false;
        return true;
    }

    public static Vector3i empty(){
        return new Vector3i(0,0,0);
    }

    public static Vector3f toVector3f(Vector3i vector){
        return new Vector3f(vector.getX(),vector.getY(),vector.getZ());
    }

    public String toString(){
        return new String("("+x + ", " + y + ", " + z + ")");
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
