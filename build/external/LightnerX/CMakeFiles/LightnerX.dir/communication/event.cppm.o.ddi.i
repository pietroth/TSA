# 0 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/event.cppm"
# 1 "/home/pietroth/Cpp/TSA/TSA/build//"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<command-line>" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/event.cppm"
module;

export module communication.event;

import std;

import communication.base_protocol;
import communication.mbt;
import network.client;

export namespace communication {
    using namespace communication;
    using namespace network;

#pragma pack(push, 1)
    struct Event {
        BaseProtocol protocol;
        MBT mbt;

        Event(std::uint16_t size, std::uint16_t typeId) : protocol(size), mbt(typeId) {}
    };
#pragma pack(pop)
}
