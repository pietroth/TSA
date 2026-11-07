# 0 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/base_protocol.cppm"
# 1 "/home/pietroth/Cpp/TSA/TSA/build//"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<command-line>" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/base_protocol.cppm"
module;

export module communication.base_protocol;

import std;

export namespace communication {
#pragma pack(push, 1)
    struct BaseProtocol {
        std::uint16_t size;

        BaseProtocol(std::uint16_t size) : size(size) {}
    };
#pragma pack(pop)
}
