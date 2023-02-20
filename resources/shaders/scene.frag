#version 330
//kalau mau hanya dari frag trs keluar
uniform vec4 uni_color;
out vec4 frag_color;


//kalau mau dari vert ke frag
//in vec3

void main() {
//    frag_color = vec4(1.0,0.0,0.0,1.0);
    frag_color = uni_color;
}