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

    private Window window = new Window(800,600, "Hello World");
    ArrayList<Object2D> object2DS = new ArrayList<>();
    ArrayList<Object2D> objectRectangles = new ArrayList<>();

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
        object2DS.add(new Object2D(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/sceneWithVerticesColor.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/sceneWithVerticesColor.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(0.0f,0.5f,0.0f),
                                new Vector3f(-0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,-0.5f,0.0f)
                        )
                ),
                new ArrayList<>(
                        List.of(
                                new Vector3f(1.0f,0.0f,0.0f),
                                new Vector3f(0.0f,1.0f,0.0f),
                                new Vector3f(0.0f,0.0f,1.0f)
                        )
                )
        ));
        object2DS.add(new Rectangle(
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
                                new Vector3f(0.0f,0.0f,0.0f),
                                new Vector3f(0.5f,0.0f,0.0f),
                                new Vector3f(0.0f,0.5f,0.0f),
                                new Vector3f(0.0f,0.0f,0.5f)
                        )
                ),
                new Vector4f(1.0f,0.0f,1.0f,1.0f),
                Arrays.asList(0,1,3,3,2,3)
        ));
    }

    public void loop() {
        while(window.isOpen()) {
            window.update();
            //command di bawah berjalan selama 1x frame, gambarnya direset hitam setiap kali
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();

            //code:
            for (Object2D i: object2DS) {
                i.drawVerticesColor();
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

    public static void main(String[] args) {
        new Main().run();
    }
}