package Engine.Math.Vector;

public class Vector2f {
    private float x, z;

    public Vector2f(float x, float z) {
        this.x = x;
        this.z = z;
    }

    public Vector2f(float u) {
        this.x = u;
        this.z = u;
    }

    public static Vector2f add(Vector2f vector1, Vector2f vector2){
        return new Vector2f(vector1.getX() + vector2.getX(), vector1.getZ() + vector2.getZ());
    }

    public void add(Vector2f vector){
        this.x += vector.x;
        this.z += vector.z;
    }

    public void add(float x, float z){
        this.x += x;
        this.z += z;
    }

    public void add(float u){
        this.x += u;
        this.z += u;
    }


    public static Vector2f substract(Vector2f vector1, Vector2f vector2){
        return new Vector2f(vector1.getX() - vector2.getX(), vector1.getZ() - vector2.getZ());
    }

    public void substract(Vector2f vector){
        this.x -= vector.x;
        this.z -= vector.z;
    }

    public void substract(float x, float z){
        this.x -= x;
        this.z -= z;
    }

    public void substract(float u){
        this.x -= u;
        this.z -= u;
    }

    public static Vector2f multiply(Vector2f vector1, Vector2f vector2){
        return new Vector2f(vector1.getX() * vector2.getX(), vector1.getZ() * vector2.getZ());
    }

    public static Vector2f multiply(Vector2f vector1, float x, float z){
        return new Vector2f(vector1.getX() * x, vector1.getZ() * z);
    }

    public static Vector2f multiply(Vector2f vector1, float u){
        return new Vector2f(vector1.getX() * u, vector1.getZ() * u);
    }

    public void multiply(Vector2f vector){
        this.x = x * vector.x;
        this.z = z * vector.z;
    }

    public void multiply(float u){
        this.x = x * u;
        this.z = z * u;
    }

    public static Vector2f divide(Vector2f vector1, Vector2f vector2){
        return new Vector2f(vector1.getX() / vector2.getX(), vector1.getZ() / vector2.getZ());
    }

    public void  divide(Vector2f vector){
        if(vector.z == 0 || vector.x == 0){
            throw new RuntimeException("Vector, Tried to divide by 0, get fucked noob");
        }
        this.x = x / vector.x;
        this.z = z / vector.z;
    }

    public static float length(Vector2f vector){
        return (float) Math.sqrt(vector.getX() * vector.getX() + vector.getZ() * vector.getZ());
    }

    public static Vector2f normalise(Vector2f vector){
        float len = Vector2f.length(vector);
        return Vector2f.divide(vector,new Vector2f(len,len));
    }

    public void normalise(){
        float len = length(this);
        divide(new Vector2f(len,len));
    }

    public void normaliseToScalar(float dLength){
        float len = length(this);
        divide(new Vector2f(len,len));
        multiply(dLength);
    }

    public static float dot(Vector2f vector1,Vector2f vector2){
        return vector1.getX() * vector2.getX() + vector1.getZ() * vector2.getZ();
    }

    public void clamp(float min,float max){
        if(x < min){
            x = min;
        }
        if(x > max){
            x = max;
        }
        if(z < min){
            z = min;
        }
        if(z > max){
            z = max;
        }
    }

    @Override
    public int hashCode() {//fucked with this so idk if it still works
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(x);
        result = prime * result + Float.floatToIntBits(z);
        return result;
    }

    //if any of our pos is greater than any of their pos but not equals
    //Ex: {1,6} > {2,2}
    public boolean isGreater(Vector2f vector){
        if(x > vector.x || z > vector.z){
            return true;
        }
        return false;
    }

    //if any of our pos is greater or equals to any of their pos
    //Ex: {1,2} > {2,2}
    public boolean isGreaterEquals(Vector2f vector){
        if(x >= vector.x || z >= vector.z){
            return true;
        }
        return false;
    }

    //if all of our pos is greater than all of their pos but not equals
    //Ex: {4,6} > {2,2}
    public boolean isGreaterStrict(Vector2f vector){
        if(x > vector.x && z > vector.z){
            return true;
        }
        return false;
    }

    //if any of our pos is greater or equals to all of their pos
    //Ex: {4,2} > {2,2}
    public boolean isGreaterEqualsStrict(Vector2f vector){
        if(x >= vector.x && z >= vector.z){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector2f other = (Vector2f) obj;
        if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
            return false;
        if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
            return false;
        return true;
    }

    public static Vector2f empty(){
        return new Vector2f(0);
    }

    public void set(float x, float z){
        this.x = x;
        this.z = z;
    }

    public void set(Vector2f vector){
        this.x = vector.x;
        this.z = vector.z;
    }

    public void set(float u){
        set(u,u);
    }

    public static Vector2f reverse(Vector2f vec){
        return new Vector2f(vec.z,vec.x);
    }

    public void reverse(){
        float temp = x;
        this.x = z;
        this.z = temp;
    }

    public Vector3f toVec3f(int y){
        return new Vector3f(x,y,z);
    }

    public Vector3i toVec3iFloor(int y){
        return new Vector3i((int) Math.floor(x), y, (int) Math.floor(z));
    }

    public Vector3i toVec3iRound(int y){
        return new Vector3i(Math.round(x), y, Math.round(z));
    }

    public String toString(){
        return new String("("+x + ", " + z + ")");
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public Vector2f clone(){
        return new Vector2f(x,z);
    }
}