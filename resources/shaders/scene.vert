#version 330
layout(location=0) in vec3 position;

//taruh di scene vert biar bisa transformasi
//posisi vertex * model, tp harus model * posisi vertex karna komputer membaca dari kanan
uniform mat4 model;

void main() {
    //shader sudah tau gmn titiknya, tinggal cara gambarnya gmn? Kita pengen ngasih warna itu di frag
    gl_Position = model * vec4(position, 1.0);
}