package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;
public class Circle extends Object2D{
    List<Float> centerPoint;
    Float radiusX;
    Float radiusY;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList, vertices, verticesColor);
    }
}
