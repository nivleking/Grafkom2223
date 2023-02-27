import Engine.Object2D;
import Engine.Rectangle;
import Engine.ShaderProgram;
import Engine.Window;
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

    ArrayList<Object2D> objectPointsControl = new ArrayList<>();

    ArrayList<Rectangle> objectStars = new ArrayList<>();

    List<Vector3f> lingkaran = new ArrayList<>();

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
//                                new Vector3f(-1.5f,-1.0f,0.0f),
//                                new Vector3f(1.5f,-1.0f,0.0f),
//                                new Vector3f(-1.5f,-0.6f,0.0f),
//                                new Vector3f(1.5f,-0.6f,0.0f)
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

        objectPointsControl.add(new Object2D(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f,1.0f,1.0f,1.0f)
        ));
    }

    public void input() {
        if (window.isKeyPressed((GLFW_KEY_W))) {
            System.out.println("W");
        }

        //buat function if di bawah ini untuk increment indexnya

        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();

            //perlu dinormalisasi sehingga 0,0 nya berada di tengah
            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);

            //minus supaya y nya di atas
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            objectRectangles.add(new Rectangle(
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
                                    new Vector3f(pos.x + 0.05f,pos.y + 0.05f,0.0f),
                                    new Vector3f(pos.x + 0.05f,pos.y - 0.05f,0.0f),
                                    new Vector3f(pos.x - 0.05f,pos.y + 0.05f,0.0f),
                                    new Vector3f(pos.x - 0.05f,pos.y - 0.05f,0.0f)
                            )
                    ),
                    new Vector4f(0.7f,0.16f,0.0f,0.0f),
                    Arrays.asList(0,1,2,1,2,3)
            ));
            //agar kliknya tidak kelebihan lebih dari 1x
            //pos.x < tidka bisa jadi -1 dan pos.y jg > jgn 1
            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y <-1))) {
                System.out.println("x : " + pos.x + " y : " + pos.y);

                //dibuat index dalam getnya
                objectPointsControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
            }
        }
    }

    public void loop() {
        while(window.isOpen()) {
            window.update();
            //command di bawah berjalan selama 1x frame, gambarnya direset hitam setiap kali
            glClearColor(0.0f,0.0f,1.0f,0.0f);
            GL.createCapabilities();

            input();
            //code:
            for (Object2D i: object2DS) {
                i.draw();
            }
            for (Object2D i: objectRectangles){
                i.draw();
            }
            for (Object2D i: objectPointsControl){
                i.drawLine();
            }
            for (Rectangle i: objectStars){
                i.drawStars();
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