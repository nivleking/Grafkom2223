#version 330
layout(location=0) in vec3 position;

void main() {
    //shader sudah tau gmn titiknya, tinggal cara gambarnya gmn? Kita pengen ngasih warna itu di frag
    gl_Position = vec4(position, 1.0);
}