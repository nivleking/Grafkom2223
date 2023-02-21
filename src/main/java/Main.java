import Engine.Object2D;
import Engine.Rectangle;
import Engine.ShaderProgram;
import Engine.Window;
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
                                new Vector3f(-1.0f,-1.0f,0.0f),
                                new Vector3f(1.0f,-1.0f,0.0f),
                                new Vector3f(-1.0f,-0.6f,0.0f),
                                new Vector3f(1.0f,-0.6f,0.0f)
                        )
                ),
                new Vector4f(0.0f,1.0f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //rumah pp #1
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
//                                new Vector3f(-0.66f,0.3f,0.0f),
//                                new Vector3f(0.66f,0.3f,0.0f)
//                        )
//                ),
//                new Vector4f(0.79f,0.6f,0.0f,0.0f),
//                Arrays.asList(0,1,2,1,2,3)
//        ));

        //rumah trapesium
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
                                new Vector3f(-0.8f,-0.1f,0.0f),
                                new Vector3f(0.8f,-0.1f,0.0f),
                                new Vector3f(-0.65f,0.34f,0.0f),
                                new Vector3f(0.65f,0.34f,0.0f)
                        )
                ),
                new Vector4f(0.95f,0.16f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //rumah window
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
                                new Vector3f(-0.66f,-0.1f,0.0f),
                                new Vector3f(-0.36f,-0.1f,0.0f),
                                new Vector3f(-0.66f,0.1f,0.0f),
                                new Vector3f(-0.6f,0.3f,0.0f)
                        )
                ),
                new Vector4f(0.79f,0.6f,0.0f,1.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //cerobong
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
                                new Vector3f(0.4f,0.2f,0.0f),
                                new Vector3f(0.5f,0.2f,0.0f),
                                new Vector3f(0.4f,0.45f,0.0f),
                                new Vector3f(0.5f,0.45f,0.0f)
                        )
                ),
                new Vector4f(0.79f,0.6f,0.0f,0.0f),
                Arrays.asList(0,1,2,1,2,3)
        ));

        //circle bulan #1
        lingkaran = generateCircle(-0.78f,0.7f,0.1f);
        object2DS.add(new Object2D(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                lingkaran,
                new Vector4f(1.0f,1.0f,0.0f,0.0f)
        ));

        //circle bulan #2
        lingkaran = generateCircle(-0.73f,0.7f,0.1f);
        object2DS.add(new Object2D(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                lingkaran,
                new Vector4f(0.0f,0.0f,1.0f,0.0f)
        ));
    }

    public void loop() {
        while(window.isOpen()) {
            window.update();
            //command di bawah berjalan selama 1x frame, gambarnya direset hitam setiap kali
            glClearColor(0.0f,0.0f,1.0f,0.0f);
            GL.createCapabilities();

            //code:
            for (Object2D i: object2DS) {
                i.draw();
            }
            for (Object2D i: objectRectangles){
                i.draw();
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
            float x2 = (float) (x + radius * Math.cos(Math.toRadians(i)));
            float y2 = (float) (y + radius * Math.sin(Math.toRadians(i)));

            lingkaran.add(new Vector3f(x2, y2, 0));
        }
        return lingkaran;
    }
    public static void main(String[] args) {
        new Main().run();
    }

}