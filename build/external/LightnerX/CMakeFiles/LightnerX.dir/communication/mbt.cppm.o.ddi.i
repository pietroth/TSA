# 0 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/mbt.cppm"
# 1 "/home/pietroth/Cpp/TSA/TSA/build//"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<command-line>" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/mbt.cppm"
module;
export module communication.mbt;

import std;

export namespace communication {
#pragma pack(push, 1)
    struct MBT {
        std::uint16_t type;

        MBT(std::uint16_t type) : type(type) {}
    };
#pragma pack(pop)
}
