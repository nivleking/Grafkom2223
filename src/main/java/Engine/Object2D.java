package Engine;

import org.joml.Vector3f;
import static org.lwjgl.opengl.GL30.*;

import java.util.List;

public class Object2D extends ShaderProgram{
    List<Vector3f> vertices;

    //untuk mengirim vertex ke window
    int vao;
    int vbo;

    public Object2D(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setVAOVBO();
    }

    public void setVAOVBO() {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,
                vbo);
        glBufferData(GL_ARRAY_BUFFER,
                Utils.listoFloat(vertices),
                GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        //dari vert ke frag lalu vert ke layar
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0, 3, GL_FLOAT, false, 0 ,0 );
    }

    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_LOOP, 0, vertices.size());
    }
}
