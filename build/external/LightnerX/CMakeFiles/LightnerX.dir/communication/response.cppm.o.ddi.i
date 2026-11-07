# 0 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/response.cppm"
# 1 "/home/pietroth/Cpp/TSA/TSA/build//"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<command-line>" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/communication/response.cppm"
module;

export module communication.response;

import std;

import communication.base_protocol;

export namespace communication {
    using namespace communication;

    constexpr std::uint8_t APPROVED_RESPONSE = 0;
    constexpr std::uint8_t DENIED_RESPONSE = 1;
    constexpr std::uint8_t PARTIALLY_APPROVED_RESPONSE = 2;
    constexpr std::uint8_t FAILURE_RESPONSE = 3;

#pragma pack(push, 1)

    struct Response {
        BaseProtocol protocol;
        std::uint16_t correlationId;
        std::uint8_t status;

        Response(std::uint16_t size, std::uint16_t correlationId, std::uint8_t status)
        : protocol(size), correlationId(correlationId), status(status) {}
    };

    struct UnsuccessfulResponse {
        BaseProtocol protocol;
        std::uint16_t correlationId;
        std::uint8_t status;
        std::uint16_t reasonCode;

        UnsuccessfulResponse(std::uint16_t size, std::uint16_t correlationId, std::uint8_t status, std::uint16_t reasonCode)
        : protocol(size), correlationId(correlationId), status(status), reasonCode(reasonCode) {}
    };

#pragma pack(pop)
}
