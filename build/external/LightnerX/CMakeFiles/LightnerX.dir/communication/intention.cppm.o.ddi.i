# 0 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/intention.cppm"
# 1 "/home/pietroth/Cpp/TSA/TSA/build//"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<command-line>" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/intention.cppm"
module;

export module communication.intention;

import std;

import communication.base_protocol;
import communication.mbt;

export namespace communication {
#pragma pack(push, 1)
    struct Intention {
        BaseProtocol protocol;
        MBT mbt;
        std::uint16_t correlationId;

        Intention(std::uint16_t size, std::uint16_t type, std::uint16_t correlationId)
            : protocol(size), mbt(type), correlationId(correlationId) {}
    };
#pragma pack(pop)
}
