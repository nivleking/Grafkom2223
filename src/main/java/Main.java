import Engine.*;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {

    private Window window = new Window(800,800, "Hello World");
    ArrayList<Object2D> object2DS = new ArrayList<>();
    ArrayList<Object2D> objectRectangles = new ArrayList<>();
    List<Vector3f> lingkaran = new ArrayList<>();
    ArrayList<Rectangle> objectStars = new ArrayList<>();
    ArrayList<Object2D> objectPointsControl = new ArrayList<>();
    Object2D controlLine;
    ArrayList<Object2D> kurva =new ArrayList<>();
    ArrayList<Vector3f> centerB = new ArrayList<>();
    ArrayList<Sphere> sphere = new ArrayList<>();


    //yg berbentuk kurva/lengkungan itu paling mudah adalah font
    //kenapa harus pakai rumus? biar lebih presisi karna kalau satu" tidak presisi
    //interpolasi itu untuk menghitung suaut kebereadaan titik di antara 2 titik
    //kalau sy punya 3 titik, sy menginterpolasi aantara 2 garis
    //jumlah titik bergantung segitiga pascal, bezier curve

    //buat dalam 3 titik, v1 v2 terserah gmn, posisi v3 senilai 0.2?
    public void init() {
        window.init();

        //function" GL
        GL.createCapabilities();

        //codingan harus taruh ditaruh di bagian bawah beriikut:
        //code

        //matahari
        sphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.8f,0.6f,0.0f,1),
                Arrays.asList(0f, 0f, 0f),
                0.01f, 0.01f, 0.01f
        ));
        //translasi, menggeser kanan
        sphere.get(0).translateObject(0.0f,0.0f,0.0f);
        sphere.get(0).scaleObject(0.3f,0.3f,0.3f);

        //merkurius
        sphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f,0.5f,0.5f,1),
                Arrays.asList(0f, 0f, 0f),
                0.01f, 0.01f, 0.01f
        ));
        //translasi, menggeser kanan
        sphere.get(1).translateObject(2.0f,2.0f,0.0f);
        sphere.get(1).scaleObject(0.1f,0.1f,0.1f);

        //venus
        sphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f,0.6f,0.0f,1),
                Arrays.asList(0f, 0f, 0f),
                0.01f, 0.01f, 0.01f
        ));
        //translasi, menggeser kanan
        sphere.get(2).translateObject(1.7f,1.7f,0.0f);
        sphere.get(2).scaleObject(0.2f,0.2f,0.2f);
//

//
        //bumi
        sphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f,0.8f,0.9f,1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.01f, 0.01f, 0.01f
        ));
        //translasi, menggeser kanan
        sphere.get(3).translateObject(2.4f,2.4f,0.0f);
        sphere.get(3).scaleObject(0.23f,0.23f,0.23f);
//
//        //bulan
        sphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.5f,0.5f,0.5f,1.0f),
                Arrays.asList(0f, 0f, 0f),
                0.01f, 0.01f, 0.01f
        ));
        //translasi, menggeser kanan
        sphere.get(4).translateObject(14.0f,14.0f,0.0f);
        sphere.get(4).scaleObject(0.05f,0.05f,0.05f);

        //        //mars
        sphere.add(new Sphere(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1),
                Arrays.asList(0f, 0f, 0f),
                0.01f, 0.01f, 0.01f
        ));
        //translasi, menggeser kanan
        sphere.get(5).translateObject(4.1f,4.1f,0.0f);
        sphere.get(5).scaleObject(0.2f,0.2f,0.2f);

//        object2DS.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
//        object2DS.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/sceneWithVerticesColor.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.0f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(1.0f,0.0f,0.0f),
//                                new Vector3f(0.0f,1.0f,0.0f),
//                                new Vector3f(0.0f,0.0f,1.0f)
//                        )
//                )
//        ));

        //tanah green
//        objectRectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.5f,0.5f,0.0f),
//                                new Vector3f(0.5f,0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,0.5f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //rumah pp #1
//        objectRectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.66f,-0.7f,0.0f),
//                                new Vector3f(0.66f,-0.7f,0.0f),
//                                new Vector3f(-0.66f,-0.1f,0.0f),
//                                new Vector3f(0.66f,-0.1f,0.0f)
//                        )
//                ),
//                new Vector4f(0.79f,0.6f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //rumah trapesium
//        objectRectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.75f,-0.1f,0.0f),
//                                new Vector3f(0.75f,-0.1f,0.0f),
//                                new Vector3f(-0.59f,0.31f,0.0f),
//                                new Vector3f(0.59f,0.31f,0.0f)
//                        )
//                ),
//                new Vector4f(0.95f,0.16f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //rumah window
//        objectRectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(-0.66f,-0.1f,0.0f),
//                                new Vector3f(-0.36f,-0.1f,0.0f),
//                                new Vector3f(-0.66f,0.005f,0.0f),
//                                new Vector3f(-0.56f,0.26f,0.0f)
//                        )
//                ),
//                new Vector4f(0.79f,0.6f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //cerobong
//        objectRectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.3f,0.2f,0.0f),
//                                new Vector3f(0.4f,0.2f,0.0f),
//                                new Vector3f(0.3f,0.45f,0.0f),
//                                new Vector3f(0.4f,0.45f,0.0f)
//                        )
//                ),
//                new Vector4f(0.79f,0.6f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //cerobong atas
//        objectRectangles.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(
//                        List.of(
//                                new Vector3f(0.25f,0.5f,0.0f),
//                                new Vector3f(0.45f,0.5f,0.0f),
//                                new Vector3f(0.25f,0.45f,0.0f),
//                                new Vector3f(0.45f,0.45f,0.0f)
//                        )
//                ),
//                new Vector4f(0.7f,0.16f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));
//
//        //circle bulan #1
//        lingkaran = generateCircle(-0.75f,0.7f,0.1f);
//        object2DS.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(1.0f,1.0f,0.0f,0.0f)
//        ));
//
//        //circle bulan #2
//        lingkaran = generateCircle(-0.7f,0.7f,0.1f);
//        object2DS.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(0.0f,0.0f,1.0f,0.0f)
//        ));
//
//        //oval asap #1
//        lingkaran = generateCircle(0.35f,0.57f,0.1f, 0.05f);
//        object2DS.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(0.5f,0.5f,0.5f,0.0f)
//        ));
//
//        //oval asap #2
//        lingkaran = generateCircle(0.42f,0.64f,0.14f, 0.05f);
//        object2DS.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(0.5f,0.5f,0.5f,0.0f)
//        ));
//
//        //oval asap #3
//        lingkaran = generateCircle(0.54f,0.71f,0.2f, 0.05f);
//        object2DS.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(0.5f,0.5f,0.5f,0.0f)
//        ));
//
//        //bintang #1
//        lingkaran = generateStars(-0.32f, 0.54f, 0.05f);
//        objectStars.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(0.5f,0.5f,0.5f,0.0f),
//                Arrays.asList(0,3,1,4,2)
//        ));
//
//        //bintang #2
//        lingkaran = generateStars(-0.04f, 0.90f, 0.02f);
//        objectStars.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(0.5f,0.5f,0.5f,0.0f),
//                Arrays.asList(0,3,1,4,2)
//        ));
//
//        //bintang #1
//        lingkaran = generateStars(0.74f, 0.86f, 0.05f);
//        objectStars.add(new Rectangle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                lingkaran,
//                new Vector4f(0.5f,0.5f,0.5f,0.0f),
//                Arrays.asList(0,3,1,4,2)
//        ));
//        objectPointsControl.add(new Object2D(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f,1.0f,1.0f,1.0f)
//        ));
    }

    public void input() {
        if (window.isKeyPressed((GLFW_KEY_W))) {
            sphere.get(0).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,1.0f);
            sphere.get(0).translateObject(0.0f,0.0f,0.0f);
        }

        if (window.isKeyPressed((GLFW_KEY_F))) {
            sphere.get(1).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.4f);
            sphere.get(2).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.4f);
            sphere.get(3).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.4f);
            sphere.get(5).rotateObject((float) Math.toRadians(0.5f),0.0f,0.0f,0.4f);
        }

        if (window.isKeyPressed(GLFW_KEY_G)) {
            sphere.get(1).rotateObject((float) Math.toRadians(0.5f),2.0f,2.0f,0.4f);
            sphere.get(1).translateObject(0.0f,0.0f,0.0f);
            sphere.get(2).rotateObject((float) Math.toRadians(0.5f),1.7f,1.7f,0.4f);
            sphere.get(2).translateObject(0.0f,0.0f,0.0f);
            sphere.get(3).rotateObject((float) Math.toRadians(0.5f),2.4f,2.4f,0.4f);
            sphere.get(3).translateObject(0.0f,0.0f,0.0f);
            sphere.get(5).rotateObject((float) Math.toRadians(0.5f),4.1f,4.1f,0.4f);
            sphere.get(5).translateObject(0.0f,0.0f,0.0f);
        }

        //buat function if di bawah ini untuk increment indexnya

        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();

            //perlu dinormalisasi sehingga 0,0 nya berada di tengah
            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);

            //minus supaya y nya di atas
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            //agar kliknya tidak kelebihan lebih dari 1x
            //pos.x < tidka bisa jadi -1 dan pos.y jg > jgn 1
            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y <-1))) {
//                System.out.println("x : " + pos.x + " y : " + pos.y);

                //dibuat index dalam getnya
                if (objectPointsControl.isEmpty() || checkOverlap(pos) == -1) {
                    objectPointsControl.add(new Rectangle(
                            Arrays.asList(
                                    //shaderFile lokasi menyesuaikan objectnya
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.vert"
                                                    , GL_VERTEX_SHADER),
                                    new ShaderProgram.ShaderModuleData
                                            ("resources/shaders/scene.frag"
                                                    , GL_FRAGMENT_SHADER)
                            ),
                            new ArrayList<>(
                                    List.of(
                                            new Vector3f(pos.x + 0.05f,pos.y - 0.05f,0.0f),
                                            new Vector3f(pos.x + 0.05f,pos.y + 0.05f,0.0f),
                                            new Vector3f(pos.x - 0.05f,pos.y + 0.05f,0.0f),
                                            new Vector3f(pos.x - 0.05f,pos.y - 0.05f,0.0f)
                                    )
                            ),
                            new Vector4f(0.0f,0.16f,0.7f,0.0f),
                            Arrays.asList(1,0,2,0,2,3)
                    ));

                    centerB.add(new Vector3f(pos.x, pos.y, 0));

                    controlLine = new Object2D(Arrays.asList(
                            // shaderFile lokasi menyesuaikan objectnya
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                    ),
                            centerB,
                            new Vector4f(1, 0.5f, 0.5f, 0.5f));

                    objectPointsControl.get(objectPointsControl.size() - 1).setVAOVBO();
                    controlLine.setVAOVBO();

//                    objectPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
                }
                //drag
                if (!objectPointsControl.isEmpty() && checkOverlap(pos) != -1) {
                    int clickedBox = checkOverlap(pos);
                    objectPointsControl.get(clickedBox).vertices.set(0, new Vector3f(pos.x + 0.05f, pos.y - 0.05f, 0));
                    objectPointsControl.get(clickedBox).vertices.set(1, new Vector3f(pos.x + 0.05f, pos.y + 0.05f, 0));
                    objectPointsControl.get(clickedBox).vertices.set(2, new Vector3f(pos.x - 0.05f, pos.y + 0.05f, 0));
                    objectPointsControl.get(clickedBox).vertices.set(3, new Vector3f(pos.x - 0.05f, pos.y - 0.05f, 0));
                    objectPointsControl.get(clickedBox).setVAOVBO();
                    centerB.set(clickedBox, new Vector3f(pos.x, pos.y, 0));
                    controlLine.setVAOVBO();
                }
            }
        }
    }

    public void loop() {
        while(window.isOpen()) {
            window.update();
            //command di bawah berjalan selama 1x frame, gambarnya direset hitam setiap kali
            glClearColor(0.1f,0.1f,0.1f,0.1f);
            GL.createCapabilities();

            bezierCurve();
            input();
            //code:
//            for (Object2D i: object2DS) {
//                i.draw();
//            }
//            for (Rectangle i: objectStars){
//                i.drawStars();
//            }
            for (Sphere i: sphere){
                i.draw();
            }
            if (controlLine != null) {
                controlLine.drawLine();
            }
            for (Object2D i: objectPointsControl){
                i.draw();
            }
            for (Object2D i: kurva){
                i.drawLine();
            }

            //Restore state
            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public int checkOverlap(Vector2f pos) {
        int index = 0;
        int collapse = -1;
        for (Object2D i : objectPointsControl) {
            boolean collisionX =
                    (pos.x + 0.05f <= i.vertices.get(2).x + 0.1f && i.vertices.get(2).x <= pos.x + 0.05f) ||
                    (pos.x - 0.05f <= i.vertices.get(2).x + 0.1f && i.vertices.get(2).x <= pos.x + 0.05f);
            boolean collisionY =
                    (pos.y + 0.05f <= i.vertices.get(3).y + 0.1f && i.vertices.get(3).y <= pos.y + 0.05f) ||
                    (pos.y - 0.05f <= i.vertices.get(3).y + 0.1f && i.vertices.get(3).y <= pos.y + 0.05f);

            if (collisionX && collisionY) {
                collapse = index;
                break;
            }
            index++;
        }

        return collapse;
    }

    public static int fact(int n) {
        if (n >= 1)
            return n * fact(n - 1);
        return 1;
    }

    public static int combi(int n, int i) {
        return (fact(n) / (fact(n-i) * fact(i)));
    }

    public static ArrayList<Integer> pascal(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(combi(n - 1, i));
        return res;
    }

    public void bezierCurve() {
        kurva.clear();
        ArrayList<Integer> pascal = pascal(centerB.size());
        ArrayList<Vector3f> titikKurva = new ArrayList<>();
        if (centerB.size() > 2) {
            for (float t = 0; t <= 1; t += 0.01) {
                float x = 0;
                float y = 0;

                for (int i = 0; i <= centerB.size() - 1; i++) {
                    x+=(pascal.get(i)*centerB.get(i).x*Math.pow(1-t,(centerB.size()-1)-i)*Math.pow(t,i));
                    y+=(pascal.get(i)*centerB.get(i).y*Math.pow(1-t,(centerB.size()-1)-i)*Math.pow(t,i));
                }
                Vector3f temp = new Vector3f(x,y,0);
                titikKurva.add(temp);
            }

            kurva.add(new Object2D(
                        Arrays.asList(
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                            new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)),
                        titikKurva,
                        new Vector4f(0.9f, 1, 0, 1)
            ));
        }

    }

    public static List<Vector3f> generateCircle(float x, float y, float radius) {
        ArrayList<Vector3f> lingkaran = new ArrayList<>();
        for (double i = 0; i < 360; i += 0.1) {
            float x2 = (float) (x + radius * Math.cos(Math.toRadians(i)));
            float y2 = (float) (y + radius * Math.sin(Math.toRadians(i)));

            lingkaran.add(new Vector3f(x2, y2, 0));
        }
        return lingkaran;
    }

    public static List<Vector3f> generateCircle(float x, float y, float radiusX, float radiusY) {
        ArrayList<Vector3f> lingkaran = new ArrayList<>();
        for (double i = 0; i < 360; i += 0.1) {
            float x2 = (float) (x + radiusX * Math.cos(Math.toRadians(i)));
            float y2 = (float) (y + radiusY * Math.sin(Math.toRadians(i)));

            lingkaran.add(new Vector3f(x2, y2, 0));
        }
        return lingkaran;
    }

    public static List<Vector3f> generateStars(float x, float y, float radius) {
        ArrayList<Vector3f> lingkaran = new ArrayList<>();
        for (double i = 0; i < 360; i += 72) {
            float x2 = (float) (x + radius * -Math.cos(Math.toRadians(i)));
            float y2 = (float) (y + radius * -Math.sin(Math.toRadians(i)));

            lingkaran.add(new Vector3f(x2, y2, 0));
        }
        return lingkaran;
    }
    public static void main(String[] args) {
        new Main().run();
    }

}