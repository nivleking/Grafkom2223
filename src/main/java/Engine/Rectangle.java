package Engine;

import jdk.jshell.execution.Util;
import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

import static org.lwjgl.opengl.GL11.glLineWidth;
import static org.lwjgl.opengl.GL11.glPointSize;
import static org.lwjgl.opengl.GL15C.*;

public class Rectangle extends Object2D{
    List<Integer> index;
    int ibo;


    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER, Utils.listoInt(index), GL_STATIC_DRAW);
    }
    public void draw() {
        drawSetup();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glDrawElements(GL_TRIANGLES, index.size(), GL_UNSIGNED_INT, 0);
    }

    public void drawStars() {
        drawSetup();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
        glLineWidth(2);
        glPointSize(2);
        glDrawElements(GL_LINE_LOOP, index.size(), GL_UNSIGNED_INT, 0);
    }
}
