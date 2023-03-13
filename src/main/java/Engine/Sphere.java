package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.lwjgl.opengl.GL11.GL_POLYGON;
import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.opengl.GL15C.*;

public class Sphere extends Circle{
    Float radiusZ;
    float stackCount;
    float sectorCount;
    List<Integer> index;
    int ibo;
    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.sectorCount = sectorCount;
        this.stackCount = stackCount;
        createSphere();
//        createHyperboloid();
//        createHyperboloid2();
//        ellipticCone();
//        ellipticParaboloid();
//        hyperboloidParabolic();
        setVAOVBO();
    }

    public void createBox() {
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertice = new ArrayList<>();

        //titik 1 kiri atas belakang
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertice.add(temp);

        //titik2 kiri bawah belakang
        temp = new Vector3f();
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertice.add(temp);

        //titik3 kanan bawah belakang
        temp = new Vector3f();
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertice.add(temp);

        //titik4 kanan atas belakang
        temp = new Vector3f();
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) - radiusZ / 2;
        tempVertice.add(temp);

        //titik5 kiri atas depan
        temp = new Vector3f();
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertice.add(temp);

        //titik6 kiri bawah depan
        temp = new Vector3f();
        temp.x = centerPoint.get(0) - radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertice.add(temp);

        //titik7 kanan bawah depan
        temp = new Vector3f();
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) - radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertice.add(temp);

        //titik8 kanan atas depan
        temp = new Vector3f();
        temp.x = centerPoint.get(0) + radiusX / 2;
        temp.y = centerPoint.get(1) + radiusY / 2;
        temp.z = centerPoint.get(2) + radiusZ / 2;
        tempVertice.add(temp);

        //        kotak belakang
        vertices.add(tempVertice.get(0));
        vertices.add(tempVertice.get(1));
        vertices.add(tempVertice.get(2));

        vertices.add(tempVertice.get(2));
        vertices.add(tempVertice.get(3));
        vertices.add(tempVertice.get(0));
//      kotak depan
        vertices.add(tempVertice.get(4));
        vertices.add(tempVertice.get(5));
        vertices.add(tempVertice.get(6));

        vertices.add(tempVertice.get(6));
        vertices.add(tempVertice.get(7));
        vertices.add(tempVertice.get(4));
//      kotak samping kiri
        vertices.add(tempVertice.get(1));
        vertices.add(tempVertice.get(5));
        vertices.add(tempVertice.get(4));

        vertices.add(tempVertice.get(4));
        vertices.add(tempVertice.get(0));
        vertices.add(tempVertice.get(1));
//      kotak samping kanan
        vertices.add(tempVertice.get(2));
        vertices.add(tempVertice.get(6));
        vertices.add(tempVertice.get(7));

        vertices.add(tempVertice.get(7));
        vertices.add(tempVertice.get(3));
        vertices.add(tempVertice.get(2));
//      kotak atas
        vertices.add(tempVertice.get(0));
        vertices.add(tempVertice.get(3));
        vertices.add(tempVertice.get(7));

        vertices.add(tempVertice.get(7));
        vertices.add(tempVertice.get(4));
        vertices.add(tempVertice.get(0));
//      kotak bawah
        vertices.add(tempVertice.get(1));
        vertices.add(tempVertice.get(2));
        vertices.add(tempVertice.get(6));

        vertices.add(tempVertice.get(6));
        vertices.add(tempVertice.get(5));
        vertices.add(tempVertice.get(1));

        // oka
//        Vector3f temp = new Vector3f();
//        ArrayList<Vector3f> tempVertices = new ArrayList<>();
//        //TITIK 1
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 2
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 3
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 4
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 5
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 6
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) + radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 7
//        temp.x = centerPoint.get(0) + radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//        //TITIK 8
//        temp.x = centerPoint.get(0) - radiusX / 2.0f;
//        temp.y = centerPoint.get(1) - radiusY / 2.0f;
//        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
//        tempVertices.add(temp);
//        temp = new Vector3f();
//
//        vertices.clear();
//        //SISI DEPAN
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(3));
//        //SISI BELAKANG
//        vertices.add(tempVertices.get(4));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(6));
//        vertices.add(tempVertices.get(7));
//        //SISI KIRI
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(4));
//        vertices.add(tempVertices.get(7));
//        vertices.add(tempVertices.get(3));
//        //SISI KANAN
//        vertices.add(tempVertices.get(0));
//        vertices.add(tempVertices.get(1));
//        vertices.add(tempVertices.get(5));
//        vertices.add(tempVertices.get(4));
//        //SISI BAWAH
//        vertices.add(tempVertices.get(3));
//        vertices.add(tempVertices.get(2));
//        vertices.add(tempVertices.get(7));
//        vertices.add(tempVertices.get(6));
    }

    public void createSphere() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        //u
        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));

            //v
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for(int i=0;i<stackCount;i++){
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;

            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
                if(i != 0){
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1+1);
                }
                if(i!=(18-1)){
                    temp_indices.add(k1+1);
                    temp_indices.add(k2);
                    temp_indices.add(k2+1);
                }
            }
        }
        this.index = temp_indices;

        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
    }

    public void createHyperboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float z = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
                float y = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
                float x = 0.5f * (float)(Math.tan(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void createHyperboloid2() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                float z = 0.5f * (float)((Math.tan(v)) * Math.cos(u));
                float y = 0.5f * (float)((Math.tan(v)) * Math.sin(u));
                float x = 0.5f * (float)(1/Math.cos(v));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void ellipticCone() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = -Math.PI; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * v * Math.cos(u));
                float y = (float) (0.5f * v * Math.sin(u));
                float z = (float) (0.5f * v);
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void ellipticParaboloid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= Math.PI; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * v * Math.cos(u));
                float y = (float) (0.5f * v * Math.sin(u));
                float z = (float) (Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void hyperboloidParabolic() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for(double v = 0; v<= 10; v+=0.1){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = (float) (0.5f * v * Math.tan(u));
                float z = (float) (0.5f * v * (1/Math.cos(u)));
                float y = (float) (Math.pow(v,2));
                temp.add(new Vector3f(x,y,z));
            }
        }
        this.vertices = temp;
    }

    public void draw() {
//        drawSetup();
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
//        glDrawElements(GL_LINE_STRIP, index.size(), GL_UNSIGNED_INT, 0);

        drawSetup();
        glLineWidth(3); //ketebalan garis
        glPointSize(3); //besar kecil vertex
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void drawIndices() {

    }
}
