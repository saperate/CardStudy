package Engine.Math.Vector;

public class Vector3f {
    private float x, y, z;

    public Vector3f(float x, float y , float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(float u){
        this.x = u;
        this.y = u;
        this.z = u;
    }

    public void set(float x, float y , float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3f add(Vector3f vector1, Vector3f vector2){
        return new Vector3f(vector1.getX() + vector2.getX(), vector1.getY() + vector2.getY(),vector1.getZ() + vector2.getZ());
    }


    public static Vector3f substract(Vector3f vector1, Vector3f vector2){
        return new Vector3f(vector1.getX() - vector2.getX(), vector1.getY() - vector2.getY(),vector1.getZ() - vector2.getZ());
    }

    public static Vector3f multiply(Vector3f vector1, Vector3f vector2){
        return new Vector3f(vector1.getX() * vector2.getX(), vector1.getY() * vector2.getY(),vector1.getZ() * vector2.getZ());
    }

    public static Vector3f multiply(float scalar, Vector3f vector){
        return new Vector3f(vector.getX() * scalar, vector.getY() * scalar,vector.getZ() * scalar);
    }

    public static Vector3f pow(int b, Vector3f vec){
        return new Vector3f((float) Math.pow(vec.getX(),b), (float) Math.pow(vec.getY(),b),(float) Math.pow(vec.getZ(),b));
    }

    public static Vector3f divide(Vector3f vector1, Vector3f vector2){
        return new Vector3f(vector1.getX() / vector2.getX(), vector1.getY() / vector2.getY(),vector1.getZ() / vector2.getZ());
    }

    public static float length(Vector3f vector){
        return (float) Math.sqrt(vector.getX() * vector.getX() + vector.getY() * vector.getY() + vector.getZ() * vector.getZ());
    }

    public float length(){
        return (float) Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY() + this.getZ() * this.getZ());
    }

    public static float distance(Vector3f v0, Vector3f v1){
        return (float) (Math.sqrt( (v0.x - v1.x)*(v0.x - v1.x) + (v0.y - v1.y)*(v0.y - v1.y) + (v0.z - v1.z)*(v0.z - v1.z)));
    }

    public static Vector3f normalise(Vector3f vector){
        float len = Vector3f.length(vector);
        return Vector3f.divide(vector,new Vector3f(len,len,len));
    }

    public static float dot(Vector3f vector1,Vector3f vector2){
        return vector1.getX() * vector2.getX() + vector1.getY() * vector2.getY() + vector1.getZ() * vector2.getZ();
    }

    public static Vector3f cross(Vector3f v0, Vector3f v1){
        float resultX = v0.getY() * v1.getZ() - v0.getZ() * v1.getY();
        float resultY = v0.getZ() * v1.getX() - v0.getX() * v1.getZ();
        float resultZ = v0.getX() * v1.getY() - v0.getY() * v1.getX();

        return new Vector3f(resultX, resultY, resultZ);
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(x);
        result = prime * result + Float.floatToIntBits(y);
        result = prime * result + Float.floatToIntBits(z);
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
        Vector3f other = (Vector3f) obj;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
            return false;
        if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
            return false;
        if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
            return false;
        return true;
    }

    public static Vector3f empty(){
        return new Vector3f(0,0,0);
    }

    public static Vector3f identity(){return new Vector3f(1,1,1);}

    public String toString(){
        return new String("("+x + ", " + y + ", " + z + ")");
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
