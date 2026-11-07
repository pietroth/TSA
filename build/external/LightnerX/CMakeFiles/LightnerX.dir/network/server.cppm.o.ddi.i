# 0 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/network/server.cppm"
# 1 "/home/pietroth/Cpp/TSA/TSA/build//"
# 0 "<built-in>"
# 0 "<command-line>"
# 1 "/usr/include/stdc-predef.h" 1 3 4
# 0 "<command-line>" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/network/server.cppm"
module;

# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h" 1




       

# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 1
# 9 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
       

# 1 "/usr/include/string.h" 1 3 4
# 26 "/usr/include/string.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/libc-header-start.h" 1 3 4
# 33 "/usr/include/x86_64-linux-gnu/bits/libc-header-start.h" 3 4
# 1 "/usr/include/features.h" 1 3 4
# 431 "/usr/include/features.h" 3 4
# 1 "/usr/include/features-time64.h" 1 3 4
# 20 "/usr/include/features-time64.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/wordsize.h" 1 3 4
# 21 "/usr/include/features-time64.h" 2 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/timesize.h" 1 3 4
# 19 "/usr/include/x86_64-linux-gnu/bits/timesize.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/wordsize.h" 1 3 4
# 20 "/usr/include/x86_64-linux-gnu/bits/timesize.h" 2 3 4
# 22 "/usr/include/features-time64.h" 2 3 4
# 432 "/usr/include/features.h" 2 3 4
# 539 "/usr/include/features.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/sys/cdefs.h" 1 3 4
# 730 "/usr/include/x86_64-linux-gnu/sys/cdefs.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/wordsize.h" 1 3 4
# 731 "/usr/include/x86_64-linux-gnu/sys/cdefs.h" 2 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/long-double.h" 1 3 4
# 732 "/usr/include/x86_64-linux-gnu/sys/cdefs.h" 2 3 4
# 540 "/usr/include/features.h" 2 3 4
# 563 "/usr/include/features.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/gnu/stubs.h" 1 3 4
# 10 "/usr/include/x86_64-linux-gnu/gnu/stubs.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/gnu/stubs-64.h" 1 3 4
# 11 "/usr/include/x86_64-linux-gnu/gnu/stubs.h" 2 3 4
# 564 "/usr/include/features.h" 2 3 4
# 34 "/usr/include/x86_64-linux-gnu/bits/libc-header-start.h" 2 3 4
# 27 "/usr/include/string.h" 2 3 4


# 28 "/usr/include/string.h" 3 4
extern "C" {
# 37 "/usr/include/string.h" 3 4
# 1 "/usr/lib/gcc/x86_64-linux-gnu/15/include/stddef.h" 1 3 4
# 229 "/usr/lib/gcc/x86_64-linux-gnu/15/include/stddef.h" 3 4
typedef long unsigned int size_t;
# 38 "/usr/include/string.h" 2 3 4
# 47 "/usr/include/string.h" 3 4
extern void *memcpy (void *__restrict __dest, const void *__restrict __src,
       size_t __n) noexcept (true) __attribute__ ((__nonnull__ (1, 2)));


extern void *memmove (void *__dest, const void *__src, size_t __n)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));





extern void *memccpy (void *__restrict __dest, const void *__restrict __src,
        int __c, size_t __n)
    noexcept (true) __attribute__ ((__nonnull__ (1, 2))) __attribute__ ((__access__ (__write_only__, 1, 4)));




extern void *memset (void *__s, int __c, size_t __n) noexcept (true) __attribute__ ((__nonnull__ (1)));




extern void *memset_explicit (void *__s, int __c, size_t __n)
     noexcept (true) __attribute__ ((__nonnull__ (1))) ;



extern int memcmp (const void *__s1, const void *__s2, size_t __n)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));
# 91 "/usr/include/string.h" 3 4
extern int __memcmpeq (const void *__s1, const void *__s2, size_t __n)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));



extern "C++"
{
extern void *memchr (void *__s, int __c, size_t __n)
      noexcept (true) __asm ("memchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
extern const void *memchr (const void *__s, int __c, size_t __n)
      noexcept (true) __asm ("memchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) void *
memchr (void *__s, int __c, size_t __n) noexcept (true)
{
  return __builtin_memchr (__s, __c, __n);
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) const void *
memchr (const void *__s, int __c, size_t __n) noexcept (true)
{
  return __builtin_memchr (__s, __c, __n);
}

}
# 130 "/usr/include/string.h" 3 4
extern "C++" void *rawmemchr (void *__s, int __c)
     noexcept (true) __asm ("rawmemchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
extern "C++" const void *rawmemchr (const void *__s, int __c)
     noexcept (true) __asm ("rawmemchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));







extern "C++" void *memrchr (void *__s, int __c, size_t __n)
      noexcept (true) __asm ("memrchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)))
      __attribute__ ((__access__ (__read_only__, 1, 3)));
extern "C++" const void *memrchr (const void *__s, int __c, size_t __n)
      noexcept (true) __asm ("memrchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)))
      __attribute__ ((__access__ (__read_only__, 1, 3)));
# 156 "/usr/include/string.h" 3 4
extern char *strcpy (char *__restrict __dest, const char *__restrict __src)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));

extern char *strncpy (char *__restrict __dest,
        const char *__restrict __src, size_t __n)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));


extern char *strcat (char *__restrict __dest, const char *__restrict __src)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));

extern char *strncat (char *__restrict __dest, const char *__restrict __src,
        size_t __n) noexcept (true) __attribute__ ((__nonnull__ (1, 2)));


extern int strcmp (const char *__s1, const char *__s2)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));

extern int strncmp (const char *__s1, const char *__s2, size_t __n)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern int strcoll (const char *__s1, const char *__s2)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));

extern size_t strxfrm (char *__restrict __dest,
         const char *__restrict __src, size_t __n)
    noexcept (true) __attribute__ ((__nonnull__ (2))) __attribute__ ((__access__ (__write_only__, 1, 3)));



# 1 "/usr/include/x86_64-linux-gnu/bits/types/locale_t.h" 1 3 4
# 22 "/usr/include/x86_64-linux-gnu/bits/types/locale_t.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/types/__locale_t.h" 1 3 4
# 27 "/usr/include/x86_64-linux-gnu/bits/types/__locale_t.h" 3 4
struct __locale_struct
{

  struct __locale_data *__locales[13];


  const unsigned short int *__ctype_b;
  const int *__ctype_tolower;
  const int *__ctype_toupper;


  const char *__names[13];
};

typedef struct __locale_struct *__locale_t;
# 23 "/usr/include/x86_64-linux-gnu/bits/types/locale_t.h" 2 3 4

typedef __locale_t locale_t;
# 188 "/usr/include/string.h" 2 3 4


extern int strcoll_l (const char *__s1, const char *__s2, locale_t __l)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2, 3)));


extern size_t strxfrm_l (char *__dest, const char *__src, size_t __n,
    locale_t __l) noexcept (true) __attribute__ ((__nonnull__ (2, 4)))
     __attribute__ ((__access__ (__write_only__, 1, 3)));





extern char *strdup (const char *__s)
     noexcept (true) __attribute__ ((__malloc__)) __attribute__ ((__nonnull__ (1)));






extern char *strndup (const char *__string, size_t __n)
     noexcept (true) __attribute__ ((__malloc__)) __attribute__ ((__nonnull__ (1)));
# 239 "/usr/include/string.h" 3 4
extern "C++"
{
extern char *strchr (char *__s, int __c)
     noexcept (true) __asm ("strchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
extern const char *strchr (const char *__s, int __c)
     noexcept (true) __asm ("strchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) char *
strchr (char *__s, int __c) noexcept (true)
{
  return __builtin_strchr (__s, __c);
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) const char *
strchr (const char *__s, int __c) noexcept (true)
{
  return __builtin_strchr (__s, __c);
}

}
# 270 "/usr/include/string.h" 3 4
extern "C++"
{
extern char *strrchr (char *__s, int __c)
     noexcept (true) __asm ("strrchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
extern const char *strrchr (const char *__s, int __c)
     noexcept (true) __asm ("strrchr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) char *
strrchr (char *__s, int __c) noexcept (true)
{
  return __builtin_strrchr (__s, __c);
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) const char *
strrchr (const char *__s, int __c) noexcept (true)
{
  return __builtin_strrchr (__s, __c);
}

}
# 304 "/usr/include/string.h" 3 4
extern "C++" char *strchrnul (char *__s, int __c)
     noexcept (true) __asm ("strchrnul") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
extern "C++" const char *strchrnul (const char *__s, int __c)
     noexcept (true) __asm ("strchrnul") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
# 316 "/usr/include/string.h" 3 4
extern size_t strcspn (const char *__s, const char *__reject)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern size_t strspn (const char *__s, const char *__accept)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern "C++"
{
extern char *strpbrk (char *__s, const char *__accept)
     noexcept (true) __asm ("strpbrk") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));
extern const char *strpbrk (const char *__s, const char *__accept)
     noexcept (true) __asm ("strpbrk") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) char *
strpbrk (char *__s, const char *__accept) noexcept (true)
{
  return __builtin_strpbrk (__s, __accept);
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) const char *
strpbrk (const char *__s, const char *__accept) noexcept (true)
{
  return __builtin_strpbrk (__s, __accept);
}

}
# 355 "/usr/include/string.h" 3 4
extern "C++"
{
extern char *strstr (char *__haystack, const char *__needle)
     noexcept (true) __asm ("strstr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));
extern const char *strstr (const char *__haystack, const char *__needle)
     noexcept (true) __asm ("strstr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) char *
strstr (char *__haystack, const char *__needle) noexcept (true)
{
  return __builtin_strstr (__haystack, __needle);
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) const char *
strstr (const char *__haystack, const char *__needle) noexcept (true)
{
  return __builtin_strstr (__haystack, __needle);
}

}
# 388 "/usr/include/string.h" 3 4
extern char *strtok (char *__restrict __s, const char *__restrict __delim)
     noexcept (true) __attribute__ ((__nonnull__ (2)));



extern char *__strtok_r (char *__restrict __s,
    const char *__restrict __delim,
    char **__restrict __save_ptr)
     noexcept (true) __attribute__ ((__nonnull__ (2, 3)));

extern char *strtok_r (char *__restrict __s, const char *__restrict __delim,
         char **__restrict __save_ptr)
     noexcept (true) __attribute__ ((__nonnull__ (2, 3)));





extern "C++" char *strcasestr (char *__haystack, const char *__needle)
     noexcept (true) __asm ("strcasestr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));
extern "C++" const char *strcasestr (const char *__haystack,
         const char *__needle)
     noexcept (true) __asm ("strcasestr") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));
# 421 "/usr/include/string.h" 3 4
extern void *memmem (const void *__haystack, size_t __haystacklen,
       const void *__needle, size_t __needlelen)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 3)))
    __attribute__ ((__access__ (__read_only__, 1, 2)))
    __attribute__ ((__access__ (__read_only__, 3, 4)));



extern void *__mempcpy (void *__restrict __dest,
   const void *__restrict __src, size_t __n)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));
extern void *mempcpy (void *__restrict __dest,
        const void *__restrict __src, size_t __n)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));




extern size_t strlen (const char *__s)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));




extern size_t strnlen (const char *__string, size_t __maxlen)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));




extern char *strerror (int __errnum) noexcept (true);
# 476 "/usr/include/string.h" 3 4
extern char *strerror_r (int __errnum, char *__buf, size_t __buflen)
     noexcept (true) __attribute__ ((__nonnull__ (2))) __attribute__ ((__warn_unused_result__)) __attribute__ ((__access__ (__write_only__, 2, 3)));




extern const char *strerrordesc_np (int __err) noexcept (true);

extern const char *strerrorname_np (int __err) noexcept (true);





extern char *strerror_l (int __errnum, locale_t __l) noexcept (true);



# 1 "/usr/include/strings.h" 1 3 4
# 23 "/usr/include/strings.h" 3 4
# 1 "/usr/lib/gcc/x86_64-linux-gnu/15/include/stddef.h" 1 3 4
# 24 "/usr/include/strings.h" 2 3 4






extern "C" {



extern int bcmp (const void *__s1, const void *__s2, size_t __n)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern void bcopy (const void *__src, void *__dest, size_t __n)
  noexcept (true) __attribute__ ((__nonnull__ (1, 2)));


extern void bzero (void *__s, size_t __n) noexcept (true) __attribute__ ((__nonnull__ (1)));



extern "C++"
{
extern char *index (char *__s, int __c)
     noexcept (true) __asm ("index") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
extern const char *index (const char *__s, int __c)
     noexcept (true) __asm ("index") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) char *
index (char *__s, int __c) noexcept (true)
{
  return __builtin_index (__s, __c);
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) const char *
index (const char *__s, int __c) noexcept (true)
{
  return __builtin_index (__s, __c);
}

}







extern "C++"
{
extern char *rindex (char *__s, int __c)
     noexcept (true) __asm ("rindex") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));
extern const char *rindex (const char *__s, int __c)
     noexcept (true) __asm ("rindex") __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1)));


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) char *
rindex (char *__s, int __c) noexcept (true)
{
  return __builtin_rindex (__s, __c);
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) const char *
rindex (const char *__s, int __c) noexcept (true)
{
  return __builtin_rindex (__s, __c);
}

}
# 104 "/usr/include/strings.h" 3 4
extern int ffs (int __i) noexcept (true) __attribute__ ((__const__));





extern int ffsl (long int __l) noexcept (true) __attribute__ ((__const__));
__extension__ extern int ffsll (long long int __ll)
     noexcept (true) __attribute__ ((__const__));



extern int strcasecmp (const char *__s1, const char *__s2)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern int strncasecmp (const char *__s1, const char *__s2, size_t __n)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));






extern int strcasecmp_l (const char *__s1, const char *__s2, locale_t __loc)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2, 3)));



extern int strncasecmp_l (const char *__s1, const char *__s2,
     size_t __n, locale_t __loc)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2, 4)));


}





# 1 "/usr/include/x86_64-linux-gnu/bits/strings_fortified.h" 1 3 4
# 22 "/usr/include/x86_64-linux-gnu/bits/strings_fortified.h" 3 4
extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void
__attribute__ ((__leaf__)) bcopy (const void *__src, void *__dest, size_t __len) noexcept (true)
{
  (void) __builtin___memmove_chk (__dest, __src, __len,
      __builtin_dynamic_object_size (__dest, 0));
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void
__attribute__ ((__leaf__)) bzero (void *__dest, size_t __len) noexcept (true)
{
  (void) __builtin___memset_chk (__dest, '\0', __len,
     __builtin_dynamic_object_size (__dest, 0));
}
# 145 "/usr/include/strings.h" 2 3 4
# 495 "/usr/include/string.h" 2 3 4



extern void explicit_bzero (void *__s, size_t __n) noexcept (true) __attribute__ ((__nonnull__ (1)))
    ;



extern char *strsep (char **__restrict __stringp,
       const char *__restrict __delim)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));




extern char *strsignal (int __sig) noexcept (true);



extern const char *sigabbrev_np (int __sig) noexcept (true);


extern const char *sigdescr_np (int __sig) noexcept (true);



extern char *__stpcpy (char *__restrict __dest, const char *__restrict __src)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));
extern char *stpcpy (char *__restrict __dest, const char *__restrict __src)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));



extern char *__stpncpy (char *__restrict __dest,
   const char *__restrict __src, size_t __n)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));
extern char *stpncpy (char *__restrict __dest,
        const char *__restrict __src, size_t __n)
     noexcept (true) __attribute__ ((__nonnull__ (1, 2)));




extern size_t strlcpy (char *__restrict __dest,
         const char *__restrict __src, size_t __n)
  noexcept (true) __attribute__ ((__nonnull__ (1, 2))) __attribute__ ((__access__ (__write_only__, 1, 3)));



extern size_t strlcat (char *__restrict __dest,
         const char *__restrict __src, size_t __n)
  noexcept (true) __attribute__ ((__nonnull__ (1, 2))) __attribute__ ((__access__ (__read_write__, 1, 3)));




extern int strverscmp (const char *__s1, const char *__s2)
     noexcept (true) __attribute__ ((__pure__)) __attribute__ ((__nonnull__ (1, 2)));


extern char *strfry (char *__string) noexcept (true) __attribute__ ((__nonnull__ (1)));


extern void *memfrob (void *__s, size_t __n) noexcept (true) __attribute__ ((__nonnull__ (1)))
    __attribute__ ((__access__ (__read_write__, 1, 2)));







extern "C++" char *basename (char *__filename)
     noexcept (true) __asm ("basename") __attribute__ ((__nonnull__ (1)));
extern "C++" const char *basename (const char *__filename)
     noexcept (true) __asm ("basename") __attribute__ ((__nonnull__ (1)));
# 580 "/usr/include/string.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/string_fortified.h" 1 3 4
# 25 "/usr/include/x86_64-linux-gnu/bits/string_fortified.h" 3 4
extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void *
__attribute__ ((__leaf__)) memcpy (void *__restrict __dest, const void *__restrict __src, size_t __len) noexcept (true)

{
  return __builtin___memcpy_chk (__dest, __src, __len,
     __builtin_dynamic_object_size (__dest, 0));
}

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void *
__attribute__ ((__leaf__)) memmove (void *__dest, const void *__src, size_t __len) noexcept (true)
{
  return __builtin___memmove_chk (__dest, __src, __len,
      __builtin_dynamic_object_size (__dest, 0));
}


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void *
__attribute__ ((__leaf__)) mempcpy (void *__restrict __dest, const void *__restrict __src, size_t __len) noexcept (true)

{
  return __builtin___mempcpy_chk (__dest, __src, __len,
      __builtin_dynamic_object_size (__dest, 0));
}
# 56 "/usr/include/x86_64-linux-gnu/bits/string_fortified.h" 3 4
extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void *
__attribute__ ((__leaf__)) memset (void *__dest, int __ch, size_t __len) noexcept (true)
{
  return __builtin___memset_chk (__dest, __ch, __len,
     __builtin_dynamic_object_size (__dest, 0));
}


void *__memset_explicit_chk (void *__s, int __c, size_t __n, size_t __destlen)
     noexcept (true) __attribute__ ((__nonnull__ (1))) ;

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void *
__attribute__ ((__leaf__)) memset_explicit (void *__dest, int __ch, size_t __len) noexcept (true)
{
  return __memset_explicit_chk (__dest, __ch, __len,
    __builtin_dynamic_object_size (__dest, 0));
}





void __explicit_bzero_chk (void *__dest, size_t __len, size_t __destlen)
  noexcept (true) __attribute__ ((__nonnull__ (1))) ;

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) void
__attribute__ ((__leaf__)) explicit_bzero (void *__dest, size_t __len) noexcept (true)
{
  __explicit_bzero_chk (__dest, __len, __builtin_dynamic_object_size (__dest, 0));
}


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) char *
__attribute__ ((__leaf__)) strcpy (char * __restrict __dest, const char *__restrict __src) noexcept (true)

    
{
  return __builtin___strcpy_chk (__dest, __src, __builtin_dynamic_object_size (__dest, 1));
}


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) char *
__attribute__ ((__leaf__)) stpcpy (char * __restrict __dest, const char *__restrict __src) noexcept (true)

    
{
  return __builtin___stpcpy_chk (__dest, __src, __builtin_dynamic_object_size (__dest, 1));
}



extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) char *
__attribute__ ((__leaf__)) strncpy (char * __restrict __dest, const char *__restrict __src, size_t __len) noexcept (true)

    
{
  return __builtin___strncpy_chk (__dest, __src, __len,
      __builtin_dynamic_object_size (__dest, 1));
}



extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) char *
__attribute__ ((__leaf__)) stpncpy (char * __dest, const char *__src, size_t __n) noexcept (true)

    
{
  return __builtin___stpncpy_chk (__dest, __src, __n,
      __builtin_dynamic_object_size (__dest, 1));
}
# 147 "/usr/include/x86_64-linux-gnu/bits/string_fortified.h" 3 4
extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) char *
__attribute__ ((__leaf__)) strcat (char * __restrict __dest, const char *__restrict __src) noexcept (true)

    
{
  return __builtin___strcat_chk (__dest, __src, __builtin_dynamic_object_size (__dest, 1));
}


extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) char *
__attribute__ ((__leaf__)) strncat (char * __restrict __dest, const char *__restrict __src, size_t __len) noexcept (true)

    
{
  return __builtin___strncat_chk (__dest, __src, __len,
      __builtin_dynamic_object_size (__dest, 1));
}


extern size_t __strlcpy_chk (char *__dest, const char *__src, size_t __n,
        size_t __destlen) noexcept (true);
extern size_t __strlcpy_alias (char *__dest, const char *__src, size_t __n) noexcept (true) __asm__ ("" "strlcpy")

                 ;

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) size_t
__attribute__ ((__leaf__)) strlcpy (char * __restrict __dest, const char *__restrict __src, size_t __n) noexcept (true)

    
{
  if (__builtin_dynamic_object_size (__dest, 1) != (size_t) -1
      && (!__builtin_constant_p (__n > __builtin_dynamic_object_size (__dest, 1))
   || __n > __builtin_dynamic_object_size (__dest, 1)))
    return __strlcpy_chk (__dest, __src, __n, __builtin_dynamic_object_size (__dest, 1));
  return __strlcpy_alias (__dest, __src, __n);
}

extern size_t __strlcat_chk (char *__dest, const char *__src, size_t __n,
        size_t __destlen) noexcept (true);
extern size_t __strlcat_alias (char *__dest, const char *__src, size_t __n) noexcept (true) __asm__ ("" "strlcat")

                 ;

extern __inline __attribute__ ((__always_inline__)) __attribute__ ((__gnu_inline__)) __attribute__ ((__artificial__)) size_t
__attribute__ ((__leaf__)) strlcat (char * __restrict __dest, const char *__restrict __src, size_t __n) noexcept (true)

{
  if (__builtin_dynamic_object_size (__dest, 1) != (size_t) -1
      && (!__builtin_constant_p (__n > __builtin_dynamic_object_size (__dest, 1))
   || __n > __builtin_dynamic_object_size (__dest, 1)))
    return __strlcat_chk (__dest, __src, __n, __builtin_dynamic_object_size (__dest, 1));
  return __strlcat_alias (__dest, __src, __n);
}
# 581 "/usr/include/string.h" 2 3 4



}
# 12 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 2
# 1 "/usr/lib/gcc/x86_64-linux-gnu/15/include/stdint.h" 1 3 4
# 9 "/usr/lib/gcc/x86_64-linux-gnu/15/include/stdint.h" 3 4
 
# 9 "/usr/lib/gcc/x86_64-linux-gnu/15/include/stdint.h" 3 4
#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wpedantic"
# 1 "/usr/include/stdint.h" 1 3 4
# 26 "/usr/include/stdint.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/libc-header-start.h" 1 3 4
# 27 "/usr/include/stdint.h" 2 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/types.h" 1 3 4
# 27 "/usr/include/x86_64-linux-gnu/bits/types.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/wordsize.h" 1 3 4
# 28 "/usr/include/x86_64-linux-gnu/bits/types.h" 2 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/timesize.h" 1 3 4
# 19 "/usr/include/x86_64-linux-gnu/bits/timesize.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/wordsize.h" 1 3 4
# 20 "/usr/include/x86_64-linux-gnu/bits/timesize.h" 2 3 4
# 29 "/usr/include/x86_64-linux-gnu/bits/types.h" 2 3 4


typedef unsigned char __u_char;
typedef unsigned short int __u_short;
typedef unsigned int __u_int;
typedef unsigned long int __u_long;


typedef signed char __int8_t;
typedef unsigned char __uint8_t;
typedef signed short int __int16_t;
typedef unsigned short int __uint16_t;
typedef signed int __int32_t;
typedef unsigned int __uint32_t;

typedef signed long int __int64_t;
typedef unsigned long int __uint64_t;






typedef __int8_t __int_least8_t;
typedef __uint8_t __uint_least8_t;
typedef __int16_t __int_least16_t;
typedef __uint16_t __uint_least16_t;
typedef __int32_t __int_least32_t;
typedef __uint32_t __uint_least32_t;
typedef __int64_t __int_least64_t;
typedef __uint64_t __uint_least64_t;



typedef long int __quad_t;
typedef unsigned long int __u_quad_t;







typedef long int __intmax_t;
typedef unsigned long int __uintmax_t;
# 141 "/usr/include/x86_64-linux-gnu/bits/types.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/typesizes.h" 1 3 4
# 142 "/usr/include/x86_64-linux-gnu/bits/types.h" 2 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/time64.h" 1 3 4
# 143 "/usr/include/x86_64-linux-gnu/bits/types.h" 2 3 4


typedef unsigned long int __dev_t;
typedef unsigned int __uid_t;
typedef unsigned int __gid_t;
typedef unsigned long int __ino_t;
typedef unsigned long int __ino64_t;
typedef unsigned int __mode_t;
typedef unsigned long int __nlink_t;
typedef long int __off_t;
typedef long int __off64_t;
typedef int __pid_t;
typedef struct { int __val[2]; } __fsid_t;
typedef long int __clock_t;
typedef unsigned long int __rlim_t;
typedef unsigned long int __rlim64_t;
typedef unsigned int __id_t;
typedef long int __time_t;
typedef unsigned int __useconds_t;
typedef long int __suseconds_t;
typedef long int __suseconds64_t;

typedef int __daddr_t;
typedef int __key_t;


typedef int __clockid_t;


typedef void * __timer_t;


typedef long int __blksize_t;




typedef long int __blkcnt_t;
typedef long int __blkcnt64_t;


typedef unsigned long int __fsblkcnt_t;
typedef unsigned long int __fsblkcnt64_t;


typedef unsigned long int __fsfilcnt_t;
typedef unsigned long int __fsfilcnt64_t;


typedef long int __fsword_t;

typedef long int __ssize_t;


typedef long int __syscall_slong_t;

typedef unsigned long int __syscall_ulong_t;



typedef __off64_t __loff_t;
typedef char *__caddr_t;


typedef long int __intptr_t;


typedef unsigned int __socklen_t;




typedef int __sig_atomic_t;
# 28 "/usr/include/stdint.h" 2 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/wchar.h" 1 3 4
# 29 "/usr/include/stdint.h" 2 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/wordsize.h" 1 3 4
# 30 "/usr/include/stdint.h" 2 3 4
# 38 "/usr/include/stdint.h" 3 4
# 1 "/usr/include/x86_64-linux-gnu/bits/stdint-intn.h" 1 3 4
# 24 "/usr/include/x86_64-linux-gnu/bits/stdint-intn.h" 3 4
typedef __int8_t int8_t;
typedef __int16_t int16_t;
typedef __int32_t int32_t;
typedef __int64_t int64_t;
# 39 "/usr/include/stdint.h" 2 3 4


# 1 "/usr/include/x86_64-linux-gnu/bits/stdint-uintn.h" 1 3 4
# 24 "/usr/include/x86_64-linux-gnu/bits/stdint-uintn.h" 3 4
typedef __uint8_t uint8_t;
typedef __uint16_t uint16_t;
typedef __uint32_t uint32_t;
typedef __uint64_t uint64_t;
# 42 "/usr/include/stdint.h" 2 3 4



# 1 "/usr/include/x86_64-linux-gnu/bits/stdint-least.h" 1 3 4
# 25 "/usr/include/x86_64-linux-gnu/bits/stdint-least.h" 3 4
typedef __int_least8_t int_least8_t;
typedef __int_least16_t int_least16_t;
typedef __int_least32_t int_least32_t;
typedef __int_least64_t int_least64_t;


typedef __uint_least8_t uint_least8_t;
typedef __uint_least16_t uint_least16_t;
typedef __uint_least32_t uint_least32_t;
typedef __uint_least64_t uint_least64_t;
# 46 "/usr/include/stdint.h" 2 3 4





typedef signed char int_fast8_t;

typedef long int int_fast16_t;
typedef long int int_fast32_t;
typedef long int int_fast64_t;
# 64 "/usr/include/stdint.h" 3 4
typedef unsigned char uint_fast8_t;

typedef unsigned long int uint_fast16_t;
typedef unsigned long int uint_fast32_t;
typedef unsigned long int uint_fast64_t;
# 80 "/usr/include/stdint.h" 3 4
typedef long int intptr_t;


typedef unsigned long int uintptr_t;
# 94 "/usr/include/stdint.h" 3 4
typedef __intmax_t intmax_t;
typedef __uintmax_t uintmax_t;
# 12 "/usr/lib/gcc/x86_64-linux-gnu/15/include/stdint.h" 2 3 4
#pragma GCC diagnostic pop
# 13 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamtypes.h" 1
# 11 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamtypes.h"

# 11 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamtypes.h"
typedef unsigned char uint8;
# 34 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamtypes.h"
typedef unsigned char uint8;
typedef signed char int8;
# 59 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamtypes.h"
typedef short int16;
typedef unsigned short uint16;
typedef int int32;
typedef unsigned int uint32;
typedef long long int64;
typedef unsigned long long uint64;







typedef long int lint64;
typedef unsigned long int ulint64;


typedef long long intp;
typedef unsigned long long uintp;







typedef uint32 AppId_t;
const AppId_t k_uAppIdInvalid = 0x0;


typedef uint32 DepotId_t;
const DepotId_t k_uDepotIdInvalid = 0x0;



typedef uint32 RTime32;


typedef uint64 SteamAPICall_t;
const SteamAPICall_t k_uAPICallInvalid = 0x0;

typedef uint32 AccountID_t;
const AccountID_t k_uAccountIdInvalid = 0;


typedef uint64 PartyBeaconID_t;
const PartyBeaconID_t k_ulPartyBeaconIdInvalid = 0;

enum ESteamIPType
{
 k_ESteamIPTypeIPv4 = 0,
 k_ESteamIPTypeIPv6 = 1,
};

#pragma pack( push, 1 )

struct SteamIPAddress_t
{
 union {

  uint32 m_unIPv4;
  uint8 m_rgubIPv6[16];


  uint64 m_ipv6Qword[2];
 };

 ESteamIPType m_eType;

 bool IsSet() const
 {
  if ( k_ESteamIPTypeIPv4 == m_eType )
  {
   return m_unIPv4 != 0;
  }
  else
  {
   return m_ipv6Qword[0] !=0 || m_ipv6Qword[1] != 0;
  }
 }

 static SteamIPAddress_t IPv4Any()
 {
  SteamIPAddress_t ipOut;
  ipOut.m_eType = k_ESteamIPTypeIPv4;
  ipOut.m_unIPv4 = 0;

  return ipOut;
 }

 static SteamIPAddress_t IPv6Any()
 {
  SteamIPAddress_t ipOut;
  ipOut.m_eType = k_ESteamIPTypeIPv6;
  ipOut.m_ipv6Qword[0] = 0;
  ipOut.m_ipv6Qword[1] = 0;

  return ipOut;
 }

 static SteamIPAddress_t IPv4Loopback()
 {
  SteamIPAddress_t ipOut;
  ipOut.m_eType = k_ESteamIPTypeIPv4;
  ipOut.m_unIPv4 = 0x7f000001;

  return ipOut;
 }

 static SteamIPAddress_t IPv6Loopback()
 {
  SteamIPAddress_t ipOut;
  ipOut.m_eType = k_ESteamIPTypeIPv6;
  ipOut.m_ipv6Qword[0] = 0;
  ipOut.m_ipv6Qword[1] = 0;
  ipOut.m_rgubIPv6[15] = 1;

  return ipOut;
 }
};

#pragma pack( pop )
# 14 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h" 1
# 11 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamuniverse.h" 1
# 15 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamuniverse.h"
enum EUniverse
{
 k_EUniverseInvalid = 0,
 k_EUniversePublic = 1,
 k_EUniverseBeta = 2,
 k_EUniverseInternal = 3,
 k_EUniverseDev = 4,

 k_EUniverseMax
};
# 12 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h" 2


enum EResult
{
 k_EResultNone = 0,
 k_EResultOK = 1,
 k_EResultFail = 2,
 k_EResultNoConnection = 3,

 k_EResultInvalidPassword = 5,
 k_EResultLoggedInElsewhere = 6,
 k_EResultInvalidProtocolVer = 7,
 k_EResultInvalidParam = 8,
 k_EResultFileNotFound = 9,
 k_EResultBusy = 10,
 k_EResultInvalidState = 11,
 k_EResultInvalidName = 12,
 k_EResultInvalidEmail = 13,
 k_EResultDuplicateName = 14,
 k_EResultAccessDenied = 15,
 k_EResultTimeout = 16,
 k_EResultBanned = 17,
 k_EResultAccountNotFound = 18,
 k_EResultInvalidSteamID = 19,
 k_EResultServiceUnavailable = 20,
 k_EResultNotLoggedOn = 21,
 k_EResultPending = 22,
 k_EResultEncryptionFailure = 23,
 k_EResultInsufficientPrivilege = 24,
 k_EResultLimitExceeded = 25,
 k_EResultRevoked = 26,
 k_EResultExpired = 27,
 k_EResultAlreadyRedeemed = 28,
 k_EResultDuplicateRequest = 29,
 k_EResultAlreadyOwned = 30,
 k_EResultIPNotFound = 31,
 k_EResultPersistFailed = 32,
 k_EResultLockingFailed = 33,
 k_EResultLogonSessionReplaced = 34,
 k_EResultConnectFailed = 35,
 k_EResultHandshakeFailed = 36,
 k_EResultIOFailure = 37,
 k_EResultRemoteDisconnect = 38,
 k_EResultShoppingCartNotFound = 39,
 k_EResultBlocked = 40,
 k_EResultIgnored = 41,
 k_EResultNoMatch = 42,
 k_EResultAccountDisabled = 43,
 k_EResultServiceReadOnly = 44,
 k_EResultAccountNotFeatured = 45,
 k_EResultAdministratorOK = 46,
 k_EResultContentVersion = 47,
 k_EResultTryAnotherCM = 48,
 k_EResultPasswordRequiredToKickSession = 49,
 k_EResultAlreadyLoggedInElsewhere = 50,
 k_EResultSuspended = 51,
 k_EResultCancelled = 52,
 k_EResultDataCorruption = 53,
 k_EResultDiskFull = 54,
 k_EResultRemoteCallFailed = 55,
 k_EResultPasswordUnset = 56,
 k_EResultExternalAccountUnlinked = 57,
 k_EResultPSNTicketInvalid = 58,
 k_EResultExternalAccountAlreadyLinked = 59,
 k_EResultRemoteFileConflict = 60,
 k_EResultIllegalPassword = 61,
 k_EResultSameAsPreviousValue = 62,
 k_EResultAccountLogonDenied = 63,
 k_EResultCannotUseOldPassword = 64,
 k_EResultInvalidLoginAuthCode = 65,
 k_EResultAccountLogonDeniedNoMail = 66,
 k_EResultHardwareNotCapableOfIPT = 67,
 k_EResultIPTInitError = 68,
 k_EResultParentalControlRestricted = 69,
 k_EResultFacebookQueryError = 70,
 k_EResultExpiredLoginAuthCode = 71,
 k_EResultIPLoginRestrictionFailed = 72,
 k_EResultAccountLockedDown = 73,
 k_EResultAccountLogonDeniedVerifiedEmailRequired = 74,
 k_EResultNoMatchingURL = 75,
 k_EResultBadResponse = 76,
 k_EResultRequirePasswordReEntry = 77,
 k_EResultValueOutOfRange = 78,
 k_EResultUnexpectedError = 79,
 k_EResultDisabled = 80,
 k_EResultInvalidCEGSubmission = 81,
 k_EResultRestrictedDevice = 82,
 k_EResultRegionLocked = 83,
 k_EResultRateLimitExceeded = 84,
 k_EResultAccountLoginDeniedNeedTwoFactor = 85,
 k_EResultItemDeleted = 86,
 k_EResultAccountLoginDeniedThrottle = 87,
 k_EResultTwoFactorCodeMismatch = 88,
 k_EResultTwoFactorActivationCodeMismatch = 89,
 k_EResultAccountAssociatedToMultiplePartners = 90,
 k_EResultNotModified = 91,
 k_EResultNoMobileDevice = 92,
 k_EResultTimeNotSynced = 93,
 k_EResultSmsCodeFailed = 94,
 k_EResultAccountLimitExceeded = 95,
 k_EResultAccountActivityLimitExceeded = 96,
 k_EResultPhoneActivityLimitExceeded = 97,
 k_EResultRefundToWallet = 98,
 k_EResultEmailSendFailure = 99,
 k_EResultNotSettled = 100,
 k_EResultNeedCaptcha = 101,
 k_EResultGSLTDenied = 102,
 k_EResultGSOwnerDenied = 103,
 k_EResultInvalidItemType = 104,
 k_EResultIPBanned = 105,
 k_EResultGSLTExpired = 106,
 k_EResultInsufficientFunds = 107,
 k_EResultTooManyPending = 108,
 k_EResultNoSiteLicensesFound = 109,
 k_EResultWGNetworkSendExceeded = 110,
 k_EResultAccountNotFriends = 111,
 k_EResultLimitedUserAccount = 112,
 k_EResultCantRemoveItem = 113,
 k_EResultAccountDeleted = 114,
 k_EResultExistingUserCancelledLicense = 115,
 k_EResultCommunityCooldown = 116,
 k_EResultNoLauncherSpecified = 117,
 k_EResultMustAgreeToSSA = 118,
 k_EResultLauncherMigrated = 119,
 k_EResultSteamRealmMismatch = 120,
 k_EResultInvalidSignature = 121,
 k_EResultParseFailure = 122,
 k_EResultNoVerifiedPhone = 123,
 k_EResultInsufficientBattery = 124,
 k_EResultChargerRequired = 125,
 k_EResultCachedCredentialInvalid = 126,
 K_EResultPhoneNumberIsVOIP = 127,
 k_EResultNotSupported = 128,
 k_EResultFamilySizeLimitExceeded = 129,
};


enum EVoiceResult
{
 k_EVoiceResultOK = 0,
 k_EVoiceResultNotInitialized = 1,
 k_EVoiceResultNotRecording = 2,
 k_EVoiceResultNoData = 3,
 k_EVoiceResultBufferTooSmall = 4,
 k_EVoiceResultDataCorrupted = 5,
 k_EVoiceResultRestricted = 6,
 k_EVoiceResultUnsupportedCodec = 7,
 k_EVoiceResultReceiverOutOfDate = 8,
 k_EVoiceResultReceiverDidNotAnswer = 9,

};


enum EDenyReason
{
 k_EDenyInvalid = 0,
 k_EDenyInvalidVersion = 1,
 k_EDenyGeneric = 2,
 k_EDenyNotLoggedOn = 3,
 k_EDenyNoLicense = 4,
 k_EDenyCheater = 5,
 k_EDenyLoggedInElseWhere = 6,
 k_EDenyUnknownText = 7,
 k_EDenyIncompatibleAnticheat = 8,
 k_EDenyMemoryCorruption = 9,
 k_EDenyIncompatibleSoftware = 10,
 k_EDenySteamConnectionLost = 11,
 k_EDenySteamConnectionError = 12,
 k_EDenySteamResponseTimedOut = 13,
 k_EDenySteamValidationStalled = 14,
 k_EDenySteamOwnerLeftGuestUser = 15,
};


typedef uint32 HAuthTicket;
const HAuthTicket k_HAuthTicketInvalid = 0;


enum EBeginAuthSessionResult
{
 k_EBeginAuthSessionResultOK = 0,
 k_EBeginAuthSessionResultInvalidTicket = 1,
 k_EBeginAuthSessionResultDuplicateRequest = 2,
 k_EBeginAuthSessionResultInvalidVersion = 3,
 k_EBeginAuthSessionResultGameMismatch = 4,
 k_EBeginAuthSessionResultExpiredTicket = 5,
};


enum EAuthSessionResponse
{
 k_EAuthSessionResponseOK = 0,
 k_EAuthSessionResponseUserNotConnectedToSteam = 1,
 k_EAuthSessionResponseNoLicenseOrExpired = 2,
 k_EAuthSessionResponseVACBanned = 3,
 k_EAuthSessionResponseLoggedInElseWhere = 4,
 k_EAuthSessionResponseVACCheckTimedOut = 5,
 k_EAuthSessionResponseAuthTicketCanceled = 6,
 k_EAuthSessionResponseAuthTicketInvalidAlreadyUsed = 7,
 k_EAuthSessionResponseAuthTicketInvalid = 8,
 k_EAuthSessionResponsePublisherIssuedBan = 9,
 k_EAuthSessionResponseAuthTicketNetworkIdentityFailure = 10,
};


enum EUserHasLicenseForAppResult
{
 k_EUserHasLicenseResultHasLicense = 0,
 k_EUserHasLicenseResultDoesNotHaveLicense = 1,
 k_EUserHasLicenseResultNoAuth = 2,
};



enum EAccountType
{
 k_EAccountTypeInvalid = 0,
 k_EAccountTypeIndividual = 1,
 k_EAccountTypeMultiseat = 2,
 k_EAccountTypeGameServer = 3,
 k_EAccountTypeAnonGameServer = 4,
 k_EAccountTypePending = 5,
 k_EAccountTypeContentServer = 6,
 k_EAccountTypeClan = 7,
 k_EAccountTypeChat = 8,
 k_EAccountTypeConsoleUser = 9,
 k_EAccountTypeAnonUser = 10,


 k_EAccountTypeMax
};






enum EChatEntryType
{
 k_EChatEntryTypeInvalid = 0,
 k_EChatEntryTypeChatMsg = 1,
 k_EChatEntryTypeTyping = 2,
 k_EChatEntryTypeInviteGame = 3,
 k_EChatEntryTypeEmote = 4,

 k_EChatEntryTypeLeftConversation = 6,

 k_EChatEntryTypeEntered = 7,
 k_EChatEntryTypeWasKicked = 8,
 k_EChatEntryTypeWasBanned = 9,
 k_EChatEntryTypeDisconnected = 10,
 k_EChatEntryTypeHistoricalChat = 11,


 k_EChatEntryTypeLinkBlocked = 14,
};





enum EChatRoomEnterResponse
{
 k_EChatRoomEnterResponseSuccess = 1,
 k_EChatRoomEnterResponseDoesntExist = 2,
 k_EChatRoomEnterResponseNotAllowed = 3,
 k_EChatRoomEnterResponseFull = 4,
 k_EChatRoomEnterResponseError = 5,
 k_EChatRoomEnterResponseBanned = 6,
 k_EChatRoomEnterResponseLimited = 7,
 k_EChatRoomEnterResponseClanDisabled = 8,
 k_EChatRoomEnterResponseCommunityBan = 9,
 k_EChatRoomEnterResponseMemberBlockedYou = 10,
 k_EChatRoomEnterResponseYouBlockedMember = 11,



 k_EChatRoomEnterResponseRatelimitExceeded = 15,
};


const unsigned int k_unSteamAccountIDMask = 0xFFFFFFFF;
const unsigned int k_unSteamAccountInstanceMask = 0x000FFFFF;
const unsigned int k_unSteamUserDefaultInstance = 1;



enum EChatSteamIDInstanceFlags
{
 k_EChatAccountInstanceMask = 0x00000FFF,

 k_EChatInstanceFlagClan = ( k_unSteamAccountInstanceMask + 1 ) >> 1,
 k_EChatInstanceFlagLobby = ( k_unSteamAccountInstanceMask + 1 ) >> 2,
 k_EChatInstanceFlagMMSLobby = ( k_unSteamAccountInstanceMask + 1 ) >> 3,


};





enum ENotificationPosition
{
 k_EPositionInvalid = -1,
 k_EPositionTopLeft = 0,
 k_EPositionTopRight = 1,
 k_EPositionBottomLeft = 2,
 k_EPositionBottomRight = 3,
};





enum EBroadcastUploadResult
{
 k_EBroadcastUploadResultNone = 0,
 k_EBroadcastUploadResultOK = 1,
 k_EBroadcastUploadResultInitFailed = 2,
 k_EBroadcastUploadResultFrameFailed = 3,
 k_EBroadcastUploadResultTimeout = 4,
 k_EBroadcastUploadResultBandwidthExceeded = 5,
 k_EBroadcastUploadResultLowFPS = 6,
 k_EBroadcastUploadResultMissingKeyFrames = 7,
 k_EBroadcastUploadResultNoConnection = 8,
 k_EBroadcastUploadResultRelayFailed = 9,
 k_EBroadcastUploadResultSettingsChanged = 10,
 k_EBroadcastUploadResultMissingAudio = 11,
 k_EBroadcastUploadResultTooFarBehind = 12,
 k_EBroadcastUploadResultTranscodeBehind = 13,
 k_EBroadcastUploadResultNotAllowedToPlay = 14,
 k_EBroadcastUploadResultBusy = 15,
 k_EBroadcastUploadResultBanned = 16,
 k_EBroadcastUploadResultAlreadyActive = 17,
 k_EBroadcastUploadResultForcedOff = 18,
 k_EBroadcastUploadResultAudioBehind = 19,
 k_EBroadcastUploadResultShutdown = 20,
 k_EBroadcastUploadResultDisconnect = 21,
 k_EBroadcastUploadResultVideoInitFailed = 22,
 k_EBroadcastUploadResultAudioInitFailed = 23,
};






enum EMarketNotAllowedReasonFlags
{
 k_EMarketNotAllowedReason_None = 0,


 k_EMarketNotAllowedReason_TemporaryFailure = (1 << 0),


 k_EMarketNotAllowedReason_AccountDisabled = (1 << 1),


 k_EMarketNotAllowedReason_AccountLockedDown = (1 << 2),


 k_EMarketNotAllowedReason_AccountLimited = (1 << 3),


 k_EMarketNotAllowedReason_TradeBanned = (1 << 4),



 k_EMarketNotAllowedReason_AccountNotTrusted = (1 << 5),


 k_EMarketNotAllowedReason_SteamGuardNotEnabled = (1 << 6),



 k_EMarketNotAllowedReason_SteamGuardOnlyRecentlyEnabled = (1 << 7),


 k_EMarketNotAllowedReason_RecentPasswordReset = (1 << 8),


 k_EMarketNotAllowedReason_NewPaymentMethod = (1 << 9),


 k_EMarketNotAllowedReason_InvalidCookie = (1 << 10),


 k_EMarketNotAllowedReason_UsingNewDevice = (1 << 11),


 k_EMarketNotAllowedReason_RecentSelfRefund = (1 << 12),


 k_EMarketNotAllowedReason_NewPaymentMethodCannotBeVerified = (1 << 13),


 k_EMarketNotAllowedReason_NoRecentPurchases = (1 << 14),


 k_EMarketNotAllowedReason_AcceptedWalletGift = (1 << 15),
};







enum EDurationControlProgress
{
 k_EDurationControlProgress_Full = 0,
 k_EDurationControlProgress_Half = 1,
 k_EDurationControlProgress_None = 2,

 k_EDurationControl_ExitSoon_3h = 3,
 k_EDurationControl_ExitSoon_5h = 4,
 k_EDurationControl_ExitSoon_Night = 5,
};






enum EDurationControlNotification
{
 k_EDurationControlNotification_None = 0,
 k_EDurationControlNotification_1Hour = 1,

 k_EDurationControlNotification_3Hours = 2,
 k_EDurationControlNotification_HalfProgress = 3,
 k_EDurationControlNotification_NoProgress = 4,

 k_EDurationControlNotification_ExitSoon_3h = 5,
 k_EDurationControlNotification_ExitSoon_5h = 6,
 k_EDurationControlNotification_ExitSoon_Night = 7,
};





enum EDurationControlOnlineState
{
 k_EDurationControlOnlineState_Invalid = 0,
 k_EDurationControlOnlineState_Offline = 1,
 k_EDurationControlOnlineState_Online = 2,
 k_EDurationControlOnlineState_OnlineHighPri = 3,
};


enum EBetaBranchFlags
{
 k_EBetaBranch_None = 0,
 k_EBetaBranch_Default = 1,
 k_EBetaBranch_Available = 2,
 k_EBetaBranch_Private = 4,
 k_EBetaBranch_Selected = 8,
 k_EBetaBranch_Installed = 16,
};

#pragma pack( push, 1 )




class CSteamID
{
public:




 CSteamID()
 {
  m_steamid.m_comp.m_unAccountID = 0;
  m_steamid.m_comp.m_EAccountType = k_EAccountTypeInvalid;
  m_steamid.m_comp.m_EUniverse = k_EUniverseInvalid;
  m_steamid.m_comp.m_unAccountInstance = 0;
 }
# 501 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
 CSteamID( uint32 unAccountID, EUniverse eUniverse, EAccountType eAccountType )
 {
  Set( unAccountID, eUniverse, eAccountType );
 }
# 514 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
 CSteamID( uint32 unAccountID, unsigned int unAccountInstance, EUniverse eUniverse, EAccountType eAccountType )
 {



  InstancedSet( unAccountID, unAccountInstance, eUniverse, eAccountType );
 }
# 529 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
 CSteamID( uint64 ulSteamID )
 {
  SetFromUint64( ulSteamID );
 }
# 547 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
 void Set( uint32 unAccountID, EUniverse eUniverse, EAccountType eAccountType )
 {
  m_steamid.m_comp.m_unAccountID = unAccountID;
  m_steamid.m_comp.m_EUniverse = eUniverse;
  m_steamid.m_comp.m_EAccountType = eAccountType;

  if ( eAccountType == k_EAccountTypeClan || eAccountType == k_EAccountTypeGameServer )
  {
   m_steamid.m_comp.m_unAccountInstance = 0;
  }
  else
  {
   m_steamid.m_comp.m_unAccountInstance = k_unSteamUserDefaultInstance;
  }
 }
# 570 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
 void InstancedSet( uint32 unAccountID, uint32 unInstance, EUniverse eUniverse, EAccountType eAccountType )
 {
  m_steamid.m_comp.m_unAccountID = unAccountID;
  m_steamid.m_comp.m_EUniverse = eUniverse;
  m_steamid.m_comp.m_EAccountType = eAccountType;
  m_steamid.m_comp.m_unAccountInstance = unInstance;
 }






 void FullSet( uint64 ulIdentifier, EUniverse eUniverse, EAccountType eAccountType )
 {
  m_steamid.m_comp.m_unAccountID = ( ulIdentifier & k_unSteamAccountIDMask );
  m_steamid.m_comp.m_unAccountInstance = ( ( ulIdentifier >> 32 ) & k_unSteamAccountInstanceMask );
  m_steamid.m_comp.m_EUniverse = eUniverse;
  m_steamid.m_comp.m_EAccountType = eAccountType;
 }






 void SetFromUint64( uint64 ulSteamID )
 {
  m_steamid.m_unAll64Bits = ulSteamID;
 }





    void Clear()
 {
  m_steamid.m_comp.m_unAccountID = 0;
  m_steamid.m_comp.m_EAccountType = k_EAccountTypeInvalid;
  m_steamid.m_comp.m_EUniverse = k_EUniverseInvalid;
  m_steamid.m_comp.m_unAccountInstance = 0;
 }





 uint64 ConvertToUint64() const
 {
  return m_steamid.m_unAll64Bits;
 }
# 630 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
 uint64 GetStaticAccountKey() const
 {

  return (uint64) ( ( ( (uint64) m_steamid.m_comp.m_EUniverse ) << 56 ) + ((uint64) m_steamid.m_comp.m_EAccountType << 52 ) + m_steamid.m_comp.m_unAccountID );
 }





 void CreateBlankAnonLogon( EUniverse eUniverse )
 {
  m_steamid.m_comp.m_unAccountID = 0;
  m_steamid.m_comp.m_EAccountType = k_EAccountTypeAnonGameServer;
  m_steamid.m_comp.m_EUniverse = eUniverse;
  m_steamid.m_comp.m_unAccountInstance = 0;
 }





 void CreateBlankAnonUserLogon( EUniverse eUniverse )
 {
  m_steamid.m_comp.m_unAccountID = 0;
  m_steamid.m_comp.m_EAccountType = k_EAccountTypeAnonUser;
  m_steamid.m_comp.m_EUniverse = eUniverse;
  m_steamid.m_comp.m_unAccountInstance = 0;
 }




 bool BBlankAnonAccount() const
 {
  return m_steamid.m_comp.m_unAccountID == 0 && BAnonAccount() && m_steamid.m_comp.m_unAccountInstance == 0;
 }




 bool BGameServerAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeGameServer || m_steamid.m_comp.m_EAccountType == k_EAccountTypeAnonGameServer;
 }




 bool BPersistentGameServerAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeGameServer;
 }




 bool BAnonGameServerAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeAnonGameServer;
 }




 bool BContentServerAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeContentServer;
 }





 bool BClanAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeClan;
 }





 bool BChatAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeChat;
 }




 bool IsLobby() const
 {
  return ( m_steamid.m_comp.m_EAccountType == k_EAccountTypeChat )
   && ( m_steamid.m_comp.m_unAccountInstance & k_EChatInstanceFlagLobby );
 }





 bool BIndividualAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeIndividual || m_steamid.m_comp.m_EAccountType == k_EAccountTypeConsoleUser;
 }





 bool BAnonAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeAnonUser || m_steamid.m_comp.m_EAccountType == k_EAccountTypeAnonGameServer;
 }




 bool BAnonUserAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeAnonUser;
 }




 bool BConsoleUserAccount() const
 {
  return m_steamid.m_comp.m_EAccountType == k_EAccountTypeConsoleUser;
 }


 void SetAccountID( uint32 unAccountID ) { m_steamid.m_comp.m_unAccountID = unAccountID; }
 void SetAccountInstance( uint32 unInstance ){ m_steamid.m_comp.m_unAccountInstance = unInstance; }

 AccountID_t GetAccountID() const { return m_steamid.m_comp.m_unAccountID; }
 uint32 GetUnAccountInstance() const { return m_steamid.m_comp.m_unAccountInstance; }
 EAccountType GetEAccountType() const { return ( EAccountType ) m_steamid.m_comp.m_EAccountType; }
 EUniverse GetEUniverse() const { return m_steamid.m_comp.m_EUniverse; }
 void SetEUniverse( EUniverse eUniverse ) { m_steamid.m_comp.m_EUniverse = eUniverse; }
 bool IsValid() const;


 explicit CSteamID( const char *pchSteamID, EUniverse eDefaultUniverse = k_EUniverseInvalid );
 const char * Render() const;
 static const char * Render( uint64 ulSteamID );

 void SetFromString( const char *pchSteamID, EUniverse eDefaultUniverse );





 bool SetFromStringStrict( const char *pchSteamID, EUniverse eDefaultUniverse );

 inline bool operator==( const CSteamID &val ) const { return m_steamid.m_unAll64Bits == val.m_steamid.m_unAll64Bits; }
 inline bool operator!=( const CSteamID &val ) const { return !operator==( val ); }
 inline bool operator<( const CSteamID &val ) const { return m_steamid.m_unAll64Bits < val.m_steamid.m_unAll64Bits; }
 inline bool operator>( const CSteamID &val ) const { return m_steamid.m_unAll64Bits > val.m_steamid.m_unAll64Bits; }


 bool BValidExternalSteamID() const;

private:




 CSteamID( uint32 );
 CSteamID( int32 );


 union SteamID_t
 {
  struct SteamIDComponent_t
  {






   uint32 m_unAccountID : 32;
   unsigned int m_unAccountInstance : 20;
   unsigned int m_EAccountType : 4;
   EUniverse m_EUniverse : 8;

  } m_comp;

  uint64 m_unAll64Bits;
 } m_steamid;
};

inline bool CSteamID::IsValid() const
{
 if ( m_steamid.m_comp.m_EAccountType <= k_EAccountTypeInvalid || m_steamid.m_comp.m_EAccountType >= k_EAccountTypeMax )
  return false;

 if ( m_steamid.m_comp.m_EUniverse <= k_EUniverseInvalid || m_steamid.m_comp.m_EUniverse >= k_EUniverseMax )
  return false;

 if ( m_steamid.m_comp.m_EAccountType == k_EAccountTypeIndividual )
 {
  if ( m_steamid.m_comp.m_unAccountID == 0 || m_steamid.m_comp.m_unAccountInstance != k_unSteamUserDefaultInstance )
   return false;
 }

 if ( m_steamid.m_comp.m_EAccountType == k_EAccountTypeClan )
 {
  if ( m_steamid.m_comp.m_unAccountID == 0 || m_steamid.m_comp.m_unAccountInstance != 0 )
   return false;
 }

 if ( m_steamid.m_comp.m_EAccountType == k_EAccountTypeGameServer )
 {
  if ( m_steamid.m_comp.m_unAccountID == 0 )
   return false;

 }
 return true;
}
# 921 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
class CGameID
{
public:

 enum EGameIDType
 {
  k_EGameIDTypeApp = 0,
  k_EGameIDTypeGameMod = 1,
  k_EGameIDTypeShortcut = 2,
  k_EGameIDTypeP2P = 3,
 };

 CGameID()
 {
  m_gameID.m_nType = k_EGameIDTypeApp;
  m_gameID.m_nAppID = k_uAppIdInvalid;
  m_gameID.m_nModID = 0;
 }

 explicit CGameID( uint64 ulGameID )
 {
  m_ulGameID = ulGameID;
 }







 explicit CGameID( int32 nAppID )
 {
  m_ulGameID = 0;
  m_gameID.m_nAppID = nAppID;
 }

 explicit CGameID( uint32 nAppID )
 {
  m_ulGameID = 0;
  m_gameID.m_nAppID = nAppID;
 }


 explicit CGameID( uint32 nAppID, uint32 nModID, CGameID::EGameIDType nType )
 {
  m_gameID.m_nAppID = nAppID;
  m_gameID.m_nModID = nModID;
  m_gameID.m_nType = nType;
 }

 CGameID( const CGameID &that )
 {
  m_ulGameID = that.m_ulGameID;
 }

 CGameID& operator=( const CGameID & that )
 {
  m_ulGameID = that.m_ulGameID;
  return *this;
 }


 explicit CGameID( const char *pchGameID );
 const char *Render() const;
 static const char *Render( uint64 ulGameID );

 uint64 ToUint64() const
 {
  return m_ulGameID;
 }

 uint64 *GetUint64Ptr()
 {
  return &m_ulGameID;
 }

 void Set( uint64 ulGameID )
 {
  m_ulGameID = ulGameID;
 }

 bool IsMod() const
 {
  return ( m_gameID.m_nType == k_EGameIDTypeGameMod );
 }

 bool IsShortcut() const
 {
  return ( m_gameID.m_nType == k_EGameIDTypeShortcut );
 }

 bool IsP2PFile() const
 {
  return ( m_gameID.m_nType == k_EGameIDTypeP2P );
 }

 bool IsSteamApp() const
 {
  return ( m_gameID.m_nType == k_EGameIDTypeApp );
 }

 uint32 ModID() const
 {
  return m_gameID.m_nModID;
 }


 uint32 AppID( bool = false ) const
 {
  return m_gameID.m_nAppID;
 }




 bool operator == ( const CGameID &rhs ) const
 {
  return m_ulGameID == rhs.m_ulGameID;
 }

 bool operator != ( const CGameID &rhs ) const
 {
  return !(*this == rhs);
 }

 bool operator < ( const CGameID &rhs ) const
 {
  return ( m_ulGameID < rhs.m_ulGameID );
 }

 bool IsValid() const
 {

  switch( m_gameID.m_nType )
  {
  case k_EGameIDTypeApp:
   return m_gameID.m_nAppID != k_uAppIdInvalid;

  case k_EGameIDTypeGameMod:
   return m_gameID.m_nAppID != k_uAppIdInvalid && (m_gameID.m_nModID & 0x80000000);

  case k_EGameIDTypeShortcut:
   return m_gameID.m_nAppID == k_uAppIdInvalid
    && (m_gameID.m_nModID & 0x80000000)
    && m_gameID.m_nModID >= (5000 | 0x80000000);

  case k_EGameIDTypeP2P:
   return m_gameID.m_nAppID == k_uAppIdInvalid && (m_gameID.m_nModID & 0x80000000);

  default:
   return false;
  }

 }

 void Reset()
 {
  m_ulGameID = 0;
 }





 struct GameID_t
 {





  unsigned int m_nAppID : 24;
  unsigned int m_nType : 8;
  unsigned int m_nModID : 32;

 };

 union
 {
  uint64 m_ulGameID;
  GameID_t m_gameID;
 };

 friend CGameID GameIDFromAppAndModPath( uint32 nAppID, const char *pchModPath );
};

#pragma pack( pop )

const int k_cchGameExtraInfoMax = 64;






typedef void (*PFNPreMinidumpCallback)(void *context);

enum EGameSearchErrorCode_t
{
 k_EGameSearchErrorCode_OK = 1,
 k_EGameSearchErrorCode_Failed_Search_Already_In_Progress = 2,
 k_EGameSearchErrorCode_Failed_No_Search_In_Progress = 3,
 k_EGameSearchErrorCode_Failed_Not_Lobby_Leader = 4,
 k_EGameSearchErrorCode_Failed_No_Host_Available = 5,
 k_EGameSearchErrorCode_Failed_Search_Params_Invalid = 6,
 k_EGameSearchErrorCode_Failed_Offline = 7,
 k_EGameSearchErrorCode_Failed_NotAuthorized = 8,
 k_EGameSearchErrorCode_Failed_Unknown_Error = 9,
};

enum EPlayerResult_t
{
 k_EPlayerResultFailedToConnect = 1,
 k_EPlayerResultAbandoned = 2,
 k_EPlayerResultKicked = 3,
 k_EPlayerResultIncomplete = 4,
 k_EPlayerResultCompleted = 5,
};


enum ESteamIPv6ConnectivityProtocol
{
 k_ESteamIPv6ConnectivityProtocol_Invalid = 0,
 k_ESteamIPv6ConnectivityProtocol_HTTP = 1,
 k_ESteamIPv6ConnectivityProtocol_UDP = 2,
};


enum ESteamIPv6ConnectivityState
{
 k_ESteamIPv6ConnectivityState_Unknown = 0,
 k_ESteamIPv6ConnectivityState_Good = 1,
 k_ESteamIPv6ConnectivityState_Bad = 2,
};
# 1172 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamclientpublic.h"
#pragma pack( push, 4 )






typedef struct ValvePackingSentinel_t
{
    uint32 m_u32;
    uint64 m_u64;
    uint16 m_u16;
    double m_d;
} ValvePackingSentinel_t;

#pragma pack( pop )



typedef char compile_time_assert_type[(sizeof(ValvePackingSentinel_t) == 24) ? 1 : -1];
# 15 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 2
# 48 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
#pragma pack( push, 4 )






struct SteamDatagramRelayAuthTicket;
struct SteamDatagramHostedAddress;
struct SteamDatagramGameCoordinatorServerLogin;
struct SteamNetConnectionStatusChangedCallback_t;
struct SteamNetAuthenticationStatus_t;
struct SteamRelayNetworkStatus_t;
struct SteamNetworkingMessagesSessionRequest_t;
struct SteamNetworkingMessagesSessionFailed_t;
struct SteamNetworkingFakeIPResult_t;

typedef void (*FnSteamNetConnectionStatusChanged)( SteamNetConnectionStatusChangedCallback_t * );
typedef void (*FnSteamNetAuthenticationStatusChanged)( SteamNetAuthenticationStatus_t * );
typedef void (*FnSteamRelayNetworkStatusChanged)(SteamRelayNetworkStatus_t *);
typedef void (*FnSteamNetworkingMessagesSessionRequest)(SteamNetworkingMessagesSessionRequest_t *);
typedef void (*FnSteamNetworkingMessagesSessionFailed)(SteamNetworkingMessagesSessionFailed_t *);
typedef void (*FnSteamNetworkingFakeIPResult)(SteamNetworkingFakeIPResult_t *);


typedef uint32 HSteamNetConnection;
const HSteamNetConnection k_HSteamNetConnection_Invalid = 0;




typedef uint32 HSteamListenSocket;
const HSteamListenSocket k_HSteamListenSocket_Invalid = 0;



typedef uint32 HSteamNetPollGroup;
const HSteamNetPollGroup k_HSteamNetPollGroup_Invalid = 0;


const int k_cchMaxSteamNetworkingErrMsg = 1024;



typedef char SteamNetworkingErrMsg[ k_cchMaxSteamNetworkingErrMsg ];



typedef uint32 SteamNetworkingPOPID;






typedef int64 SteamNetworkingMicroseconds;


enum ESteamNetworkingAvailability
{






 k_ESteamNetworkingAvailability_CannotTry = -102,
 k_ESteamNetworkingAvailability_Failed = -101,
 k_ESteamNetworkingAvailability_Previously = -100,

 k_ESteamNetworkingAvailability_Retrying = -10,


 k_ESteamNetworkingAvailability_NeverTried = 1,
 k_ESteamNetworkingAvailability_Waiting = 2,
 k_ESteamNetworkingAvailability_Attempting = 3,

 k_ESteamNetworkingAvailability_Current = 100,


 k_ESteamNetworkingAvailability_Unknown = 0,
 k_ESteamNetworkingAvailability__Force32bit = 0x7fffffff,
};






enum ESteamNetworkingIdentityType
{




 k_ESteamNetworkingIdentityType_Invalid = 0,




 k_ESteamNetworkingIdentityType_SteamID = 16,
 k_ESteamNetworkingIdentityType_XboxPairwiseID = 17,
 k_ESteamNetworkingIdentityType_SonyPSN = 18,
# 166 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingIdentityType_IPAddress = 1,





 k_ESteamNetworkingIdentityType_GenericString = 2,
 k_ESteamNetworkingIdentityType_GenericBytes = 3,






 k_ESteamNetworkingIdentityType_UnknownType = 4,


 k_ESteamNetworkingIdentityType__Force32bit = 0x7fffffff,
};



enum ESteamNetworkingFakeIPType
{
 k_ESteamNetworkingFakeIPType_Invalid,
 k_ESteamNetworkingFakeIPType_NotFake,
 k_ESteamNetworkingFakeIPType_GlobalIPv4,
 k_ESteamNetworkingFakeIPType_LocalIPv4,

 k_ESteamNetworkingFakeIPType__Force32Bit = 0x7fffffff
};

#pragma pack(push,1)




struct SteamNetworkingIPAddr
{
 void Clear();
 bool IsIPv6AllZeros() const;
 void SetIPv6( const uint8 *ipv6, uint16 nPort );
 void SetIPv4( uint32 nIP, uint16 nPort );
 bool IsIPv4() const;
 uint32 GetIPv4() const;
 void SetIPv6LocalHost( uint16 nPort = 0);
 bool IsLocalHost() const;



 enum { k_cchMaxString = 48 };
# 225 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 inline void ToString( char *buf, size_t cbBuf, bool bWithPort ) const;



 inline bool ParseString( const char *pszStr );


 struct IPv4MappedAddress {
  uint64 m_8zeros;
  uint16 m_0000;
  uint16 m_ffff;
  uint8 m_ip[ 4 ];
 };

 union
 {
  uint8 m_ipv6[ 16 ];
  IPv4MappedAddress m_ipv4;
 };
 uint16 m_port;


 bool operator==(const SteamNetworkingIPAddr &x ) const;



 ESteamNetworkingFakeIPType GetFakeIPType() const;


 bool IsFakeIP() const { return GetFakeIPType() > k_ESteamNetworkingFakeIPType_NotFake; }
};






struct SteamNetworkingIdentity
{

 ESteamNetworkingIdentityType m_eType;





 void Clear();
 bool IsInvalid() const;

 void SetSteamID( CSteamID steamID );
 CSteamID GetSteamID() const;
 void SetSteamID64( uint64 steamID );
 uint64 GetSteamID64() const;

 bool SetXboxPairwiseID( const char *pszString );
 const char *GetXboxPairwiseID() const;

 void SetPSNID( uint64 id );
 uint64 GetPSNID() const;

 void SetIPAddr( const SteamNetworkingIPAddr &addr );
 const SteamNetworkingIPAddr *GetIPAddr() const;
 void SetIPv4Addr( uint32 nIPv4, uint16 nPort );
 uint32 GetIPv4() const;

 ESteamNetworkingFakeIPType GetFakeIPType() const;
 bool IsFakeIP() const { return GetFakeIPType() > k_ESteamNetworkingFakeIPType_NotFake; }



 void SetLocalHost();
 bool IsLocalHost() const;

 bool SetGenericString( const char *pszString );
 const char *GetGenericString() const;

 bool SetGenericBytes( const void *data, size_t cbLen );
 const uint8 *GetGenericBytes( int &cbLen ) const;


 bool operator==(const SteamNetworkingIdentity &x ) const;







 void ToString( char *buf, size_t cbBuf ) const;






 bool ParseString( const char *pszStr );


 enum {
  k_cchMaxString = 128,
  k_cchMaxGenericString = 32,
  k_cchMaxXboxPairwiseID = 33,
  k_cbMaxGenericBytes = 32,
 };







 int m_cbSize;
 union {
  uint64 m_steamID64;
  uint64 m_PSNID;
  char m_szGenericString[ k_cchMaxGenericString ];
  char m_szXboxPairwiseID[ k_cchMaxXboxPairwiseID ];
  uint8 m_genericBytes[ k_cbMaxGenericBytes ];
  char m_szUnknownRawString[ k_cchMaxString ];
  SteamNetworkingIPAddr m_ip;
  uint32 m_reserved[ 32 ];
 };
};
#pragma pack(pop)






enum ESteamNetworkingConnectionState
{



 k_ESteamNetworkingConnectionState_None = 0,
# 385 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConnectionState_Connecting = 1,







 k_ESteamNetworkingConnectionState_FindingRoute = 2,







 k_ESteamNetworkingConnectionState_Connected = 3,
# 410 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConnectionState_ClosedByPeer = 4,
# 420 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConnectionState_ProblemDetectedLocally = 5,
# 435 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConnectionState_FinWait = -1,
# 451 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConnectionState_Linger = -2,


 k_ESteamNetworkingConnectionState_Dead = -3,

 k_ESteamNetworkingConnectionState__Force32Bit = 0x7fffffff
};




enum ESteamNetConnectionEnd
{

 k_ESteamNetConnectionEnd_Invalid = 0,
# 485 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetConnectionEnd_App_Min = 1000,
  k_ESteamNetConnectionEnd_App_Generic = k_ESteamNetConnectionEnd_App_Min,

 k_ESteamNetConnectionEnd_App_Max = 1999,





 k_ESteamNetConnectionEnd_AppException_Min = 2000,
  k_ESteamNetConnectionEnd_AppException_Generic = k_ESteamNetConnectionEnd_AppException_Min,

 k_ESteamNetConnectionEnd_AppException_Max = 2999,
# 508 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetConnectionEnd_Local_Min = 3000,


  k_ESteamNetConnectionEnd_Local_OfflineMode = 3001,
# 524 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
  k_ESteamNetConnectionEnd_Local_ManyRelayConnectivity = 3002,




  k_ESteamNetConnectionEnd_Local_HostedServerPrimaryRelay = 3003,




  k_ESteamNetConnectionEnd_Local_NetworkConfig = 3004,



  k_ESteamNetConnectionEnd_Local_Rights = 3005,







  k_ESteamNetConnectionEnd_Local_P2P_ICE_NoPublicAddresses = 3006,

 k_ESteamNetConnectionEnd_Local_Max = 3999,





 k_ESteamNetConnectionEnd_Remote_Min = 4000,





  k_ESteamNetConnectionEnd_Remote_Timeout = 4001,




  k_ESteamNetConnectionEnd_Remote_BadCrypt = 4002,
# 576 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
  k_ESteamNetConnectionEnd_Remote_BadCert = 4003,







  k_ESteamNetConnectionEnd_Remote_BadProtocolVersion = 4006,
# 593 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
  k_ESteamNetConnectionEnd_Remote_P2P_ICE_NoPublicAddresses = 4007,

 k_ESteamNetConnectionEnd_Remote_Max = 4999,


 k_ESteamNetConnectionEnd_Misc_Min = 5000,





  k_ESteamNetConnectionEnd_Misc_Generic = 5001,


  k_ESteamNetConnectionEnd_Misc_InternalError = 5002,




  k_ESteamNetConnectionEnd_Misc_Timeout = 5003,




  k_ESteamNetConnectionEnd_Misc_SteamConnectivity = 5005,




  k_ESteamNetConnectionEnd_Misc_NoRelaySessionsToClient = 5006,







  k_ESteamNetConnectionEnd_Misc_P2P_Rendezvous = 5008,






  k_ESteamNetConnectionEnd_Misc_P2P_NAT_Firewall = 5009,
# 652 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
  k_ESteamNetConnectionEnd_Misc_PeerSentNoConnection = 5010,

 k_ESteamNetConnectionEnd_Misc_Max = 5999,

 k_ESteamNetConnectionEnd__Force32Bit = 0x7fffffff
};



const int k_cchSteamNetworkingMaxConnectionCloseReason = 128;



const int k_cchSteamNetworkingMaxConnectionDescription = 128;


const int k_cchSteamNetworkingMaxConnectionAppName = 32;

const int k_nSteamNetworkConnectionInfoFlags_Unauthenticated = 1;
const int k_nSteamNetworkConnectionInfoFlags_Unencrypted = 2;
const int k_nSteamNetworkConnectionInfoFlags_LoopbackBuffers = 4;
const int k_nSteamNetworkConnectionInfoFlags_Fast = 8;
const int k_nSteamNetworkConnectionInfoFlags_Relayed = 16;
const int k_nSteamNetworkConnectionInfoFlags_DualWifi = 32;


struct SteamNetConnectionInfo_t
{


 SteamNetworkingIdentity m_identityRemote;


 int64 m_nUserData;


 HSteamListenSocket m_hListenSocket;



 SteamNetworkingIPAddr m_addrRemote;
 uint16 m__pad1;


 SteamNetworkingPOPID m_idPOPRemote;



 SteamNetworkingPOPID m_idPOPRelay;


 ESteamNetworkingConnectionState m_eState;



 int m_eEndReason;





 char m_szEndDebug[ k_cchSteamNetworkingMaxConnectionCloseReason ];
# 722 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 char m_szConnectionDescription[ k_cchSteamNetworkingMaxConnectionDescription ];


 int m_nFlags;


 uint32 reserved[63];
};



struct SteamNetConnectionRealTimeStatus_t
{


 ESteamNetworkingConnectionState m_eState;


 int m_nPing;



 float m_flConnectionQualityLocal;


 float m_flConnectionQualityRemote;


 float m_flOutPacketsPerSec;
 float m_flOutBytesPerSec;
 float m_flInPacketsPerSec;
 float m_flInBytesPerSec;





 int m_nSendRateBytesPerSecond;
# 768 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 int m_cbPendingUnreliable;
 int m_cbPendingReliable;




 int m_cbSentUnackedReliable;
# 803 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 SteamNetworkingMicroseconds m_usecQueueTime;
# 812 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 int32 m_usecMaxJitter;


 uint32 reserved[15];
};


struct SteamNetConnectionRealTimeLaneStatus_t
{


 int m_cbPendingUnreliable;
 int m_cbPendingReliable;
 int m_cbSentUnackedReliable;
 int _reservePad1;




 SteamNetworkingMicroseconds m_usecQueueTime;


 uint32 reserved[10];
};

#pragma pack( pop )
# 846 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
const int k_cbMaxSteamNetworkingSocketsMessageSizeSend = 512 * 1024;


struct SteamNetworkingMessage_t
{


 void *m_pData;


 int m_cbSize;




 HSteamNetConnection m_conn;




 SteamNetworkingIdentity m_identityPeer;
# 884 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 int64 m_nConnUserData;



 SteamNetworkingMicroseconds m_usecTimeReceived;





 int64 m_nMessageNumber;







 void (*m_pfnFreeData)( SteamNetworkingMessage_t *pMsg );




 void (*m_pfnRelease)( SteamNetworkingMessage_t *pMsg );



 int m_nChannel;




 int m_nFlags;






 int64 m_nUserData;



 uint16 m_idxLane;
 uint16 _pad1__;



 inline void Release();



 inline uint32 GetSize() const { return m_cbSize; }
 inline const void *GetData() const { return m_pData; }
 inline int GetChannel() const { return m_nChannel; }
 inline HSteamNetConnection GetConnection() const { return m_conn; }
 inline int64 GetConnectionUserData() const { return m_nConnUserData; }
 inline SteamNetworkingMicroseconds GetTimeReceived() const { return m_usecTimeReceived; }
 inline int64 GetMessageNumber() const { return m_nMessageNumber; }

protected:





 inline ~SteamNetworkingMessage_t() {}
};
# 968 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
const int k_nSteamNetworkingSend_Unreliable = 0;
# 985 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
const int k_nSteamNetworkingSend_NoNagle = 1;






const int k_nSteamNetworkingSend_UnreliableNoNagle = k_nSteamNetworkingSend_Unreliable|k_nSteamNetworkingSend_NoNagle;




const int k_nSteamNetworkingSend_NoDelay = 4;
# 1013 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
const int k_nSteamNetworkingSend_UnreliableNoDelay = k_nSteamNetworkingSend_Unreliable|k_nSteamNetworkingSend_NoDelay|k_nSteamNetworkingSend_NoNagle;
# 1024 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
const int k_nSteamNetworkingSend_Reliable = 8;




const int k_nSteamNetworkingSend_ReliableNoNagle = k_nSteamNetworkingSend_Reliable|k_nSteamNetworkingSend_NoNagle;
# 1044 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
const int k_nSteamNetworkingSend_UseCurrentThread = 16;
# 1065 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
const int k_nSteamNetworkingSend_AutoRestartBrokenSession = 32;
# 1084 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
struct SteamNetworkPingLocation_t
{
 uint8 m_data[ 512 ];
};






const int k_cchMaxSteamNetworkingPingLocationString = 1024;


const int k_nSteamNetworkingPing_Failed = -1;
const int k_nSteamNetworkingPing_Unknown = -2;






enum ESteamNetworkingConfigScope
{





 k_ESteamNetworkingConfig_Global = 1,




 k_ESteamNetworkingConfig_SocketsInterface = 2,






 k_ESteamNetworkingConfig_ListenSocket = 3,


 k_ESteamNetworkingConfig_Connection = 4,

 k_ESteamNetworkingConfigScope__Force32Bit = 0x7fffffff
};


enum ESteamNetworkingConfigDataType
{
 k_ESteamNetworkingConfig_Int32 = 1,
 k_ESteamNetworkingConfig_Int64 = 2,
 k_ESteamNetworkingConfig_Float = 3,
 k_ESteamNetworkingConfig_String = 4,
 k_ESteamNetworkingConfig_Ptr = 5,

 k_ESteamNetworkingConfigDataType__Force32Bit = 0x7fffffff
};


enum ESteamNetworkingConfigValue
{
 k_ESteamNetworkingConfig_Invalid = 0,






 k_ESteamNetworkingConfig_TimeoutInitial = 24,


 k_ESteamNetworkingConfig_TimeoutConnected = 25,




 k_ESteamNetworkingConfig_SendBufferSize = 9,







 k_ESteamNetworkingConfig_RecvBufferSize = 47,





 k_ESteamNetworkingConfig_RecvBufferMessages = 48,







 k_ESteamNetworkingConfig_RecvMaxMessageSize = 49,
# 1198 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_RecvMaxSegmentsPerPacket = 50,
# 1233 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_ConnectionUserData = 40,







 k_ESteamNetworkingConfig_SendRateMin = 10,
 k_ESteamNetworkingConfig_SendRateMax = 11,
# 1251 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_NagleTime = 12,
# 1265 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_IP_AllowWithoutAuth = 23,




 k_ESteamNetworkingConfig_IPLocalHost_AllowWithoutAuth = 52,




 k_ESteamNetworkingConfig_MTU_PacketSize = 32,



 k_ESteamNetworkingConfig_MTU_DataSize = 33,
# 1290 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_Unencrypted = 34,
# 1376 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_SymmetricConnect = 37,
# 1391 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_LocalVirtualPort = 38,



 k_ESteamNetworkingConfig_DualWifi_Enable = 39,



 k_ESteamNetworkingConfig_EnableDiagnosticsUI = 46,
# 1410 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_SendTimeSincePreviousPacket = 59,
# 1422 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_FakePacketLoss_Send = 2,
 k_ESteamNetworkingConfig_FakePacketLoss_Recv = 3,


 k_ESteamNetworkingConfig_FakePacketLag_Send = 4,
 k_ESteamNetworkingConfig_FakePacketLag_Recv = 5,
# 1453 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_FakePacketJitter_Send_Avg = 53,
 k_ESteamNetworkingConfig_FakePacketJitter_Send_Max = 54,
 k_ESteamNetworkingConfig_FakePacketJitter_Send_Pct = 55,
 k_ESteamNetworkingConfig_FakePacketJitter_Recv_Avg = 56,
 k_ESteamNetworkingConfig_FakePacketJitter_Recv_Max = 57,
 k_ESteamNetworkingConfig_FakePacketJitter_Recv_Pct = 58,
# 1468 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_FakePacketReorder_Send = 6,
 k_ESteamNetworkingConfig_FakePacketReorder_Recv = 7,



 k_ESteamNetworkingConfig_FakePacketReorder_Time = 8,


 k_ESteamNetworkingConfig_FakePacketDup_Send = 26,
 k_ESteamNetworkingConfig_FakePacketDup_Recv = 27,



 k_ESteamNetworkingConfig_FakePacketDup_TimeMax = 28,




 k_ESteamNetworkingConfig_PacketTraceMaxBytes = 41,
# 1497 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_FakeRateLimit_Send_Rate = 42,
 k_ESteamNetworkingConfig_FakeRateLimit_Send_Burst = 43,
 k_ESteamNetworkingConfig_FakeRateLimit_Recv_Rate = 44,
 k_ESteamNetworkingConfig_FakeRateLimit_Recv_Burst = 45,
# 1526 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_OutOfOrderCorrectionWindowMicroseconds = 51,
# 1564 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_Callback_ConnectionStatusChanged = 201,





 k_ESteamNetworkingConfig_Callback_AuthStatusChanged = 202,





 k_ESteamNetworkingConfig_Callback_RelayNetworkStatusChanged = 203,




 k_ESteamNetworkingConfig_Callback_MessagesSessionRequest = 204,





 k_ESteamNetworkingConfig_Callback_MessagesSessionFailed = 205,





 k_ESteamNetworkingConfig_Callback_CreateConnectionSignaling = 206,




 k_ESteamNetworkingConfig_Callback_FakeIPResult = 207,
# 1619 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_P2P_STUN_ServerList = 103,



 k_ESteamNetworkingConfig_P2P_Transport_ICE_Enable = 104,





 k_ESteamNetworkingConfig_P2P_Transport_ICE_Penalty = 105,
 k_ESteamNetworkingConfig_P2P_Transport_SDR_Penalty = 106,
 k_ESteamNetworkingConfig_P2P_TURN_ServerList = 107,
 k_ESteamNetworkingConfig_P2P_TURN_UserList = 108,
 k_ESteamNetworkingConfig_P2P_TURN_PassList = 109,

 k_ESteamNetworkingConfig_P2P_Transport_ICE_Implementation = 110,
# 1644 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_SDRClient_ConsecutitivePingTimeoutsFailInitial = 19,




 k_ESteamNetworkingConfig_SDRClient_ConsecutitivePingTimeoutsFail = 20,






 k_ESteamNetworkingConfig_SDRClient_MinPingsBeforePingAccurate = 21,







 k_ESteamNetworkingConfig_SDRClient_SingleSocket = 22,



 k_ESteamNetworkingConfig_SDRClient_ForceRelayCluster = 29,







 k_ESteamNetworkingConfig_SDRClient_DevTicket = 30,



 k_ESteamNetworkingConfig_SDRClient_ForceProxyAddr = 31,






 k_ESteamNetworkingConfig_SDRClient_FakeClusterPing = 36,



 k_ESteamNetworkingConfig_SDRClient_LimitPingProbesToNearestN = 60,
# 1701 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_LogLevel_AckRTT = 13,
 k_ESteamNetworkingConfig_LogLevel_PacketDecode = 14,
 k_ESteamNetworkingConfig_LogLevel_Message = 15,
 k_ESteamNetworkingConfig_LogLevel_PacketGaps = 16,
 k_ESteamNetworkingConfig_LogLevel_P2PRendezvous = 17,
 k_ESteamNetworkingConfig_LogLevel_SDRRelayPings = 18,
# 1717 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 k_ESteamNetworkingConfig_ECN = 999,



 k_ESteamNetworkingConfig_SDRClient_EnableTOSProbes = 998,




 k_ESteamNetworkingConfig_DELETED_EnumerateDevVars = 35,

 k_ESteamNetworkingConfigValue__Force32Bit = 0x7fffffff
};


const int k_nSteamNetworkingConfig_P2P_Transport_ICE_Enable_Default = -1;
const int k_nSteamNetworkingConfig_P2P_Transport_ICE_Enable_Disable = 0;
const int k_nSteamNetworkingConfig_P2P_Transport_ICE_Enable_Relay = 1;
const int k_nSteamNetworkingConfig_P2P_Transport_ICE_Enable_Private = 2;
const int k_nSteamNetworkingConfig_P2P_Transport_ICE_Enable_Public = 4;
const int k_nSteamNetworkingConfig_P2P_Transport_ICE_Enable_All = 0x7fffffff;
# 1750 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
struct SteamNetworkingConfigValue_t
{

 ESteamNetworkingConfigValue m_eValue;


 ESteamNetworkingConfigDataType m_eDataType;


 union
 {
  int32_t m_int32;
  int64_t m_int64;
  float m_float;
  const char *m_string;
  void *m_ptr;
 } m_val;




 inline void SetInt32( ESteamNetworkingConfigValue eVal, int32_t data )
 {
  m_eValue = eVal;
  m_eDataType = k_ESteamNetworkingConfig_Int32;
  m_val.m_int32 = data;
 }
 inline void SetInt64( ESteamNetworkingConfigValue eVal, int64_t data )
 {
  m_eValue = eVal;
  m_eDataType = k_ESteamNetworkingConfig_Int64;
  m_val.m_int64 = data;
 }
 inline void SetFloat( ESteamNetworkingConfigValue eVal, float data )
 {
  m_eValue = eVal;
  m_eDataType = k_ESteamNetworkingConfig_Float;
  m_val.m_float = data;
 }
 inline void SetPtr( ESteamNetworkingConfigValue eVal, void *data )
 {
  m_eValue = eVal;
  m_eDataType = k_ESteamNetworkingConfig_Ptr;
  m_val.m_ptr = data;
 }
 inline void SetString( ESteamNetworkingConfigValue eVal, const char *data )
 {
  m_eValue = eVal;
  m_eDataType = k_ESteamNetworkingConfig_String;
  m_val.m_string = data;
 }
};


enum ESteamNetworkingGetConfigValueResult
{
 k_ESteamNetworkingGetConfigValue_BadValue = -1,
 k_ESteamNetworkingGetConfigValue_BadScopeObj = -2,
 k_ESteamNetworkingGetConfigValue_BufferTooSmall = -3,
 k_ESteamNetworkingGetConfigValue_OK = 1,
 k_ESteamNetworkingGetConfigValue_OKInherited = 2,

 k_ESteamNetworkingGetConfigValueResult__Force32Bit = 0x7fffffff
};







enum ESteamNetworkingSocketsDebugOutputType
{
 k_ESteamNetworkingSocketsDebugOutputType_None = 0,
 k_ESteamNetworkingSocketsDebugOutputType_Bug = 1,
 k_ESteamNetworkingSocketsDebugOutputType_Error = 2,
 k_ESteamNetworkingSocketsDebugOutputType_Important = 3,
 k_ESteamNetworkingSocketsDebugOutputType_Warning = 4,
 k_ESteamNetworkingSocketsDebugOutputType_Msg = 5,
 k_ESteamNetworkingSocketsDebugOutputType_Verbose = 6,
 k_ESteamNetworkingSocketsDebugOutputType_Debug = 7,
 k_ESteamNetworkingSocketsDebugOutputType_Everything = 8,

 k_ESteamNetworkingSocketsDebugOutputType__Force32Bit = 0x7fffffff
};


typedef void (*FSteamNetworkingSocketsDebugOutput)( ESteamNetworkingSocketsDebugOutputType nType, const char *pszMsg );






inline SteamNetworkingPOPID CalculateSteamNetworkingPOPIDFromString( const char *pszCode )
{
# 1856 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
 SteamNetworkingPOPID result = (uint32)(uint8)pszCode[0] << 16U;
 if ( result && pszCode[1] )
 {
  result |= ( (uint32)(uint8)pszCode[1] << 8U );
  if ( pszCode[2] )
  {
   result |= (uint32)(uint8)pszCode[2] | ( (uint32)(uint8)pszCode[3] << 24U );
  }
 }
 return result;
}




template <int N>
inline void GetSteamNetworkingLocationPOPStringFromID( SteamNetworkingPOPID id, char (&szCode)[N] )
{
 static_assert( N >= 5, "Fixed-size buffer not big enough to hold SDR POP ID" );
 szCode[0] = char( id >> 16U );
 szCode[1] = char( id >> 8U );
 szCode[2] = char( id );
 szCode[3] = char( id >> 24U );
 szCode[4] = 0;
}


const SteamNetworkingPOPID k_SteamDatagramPOPID_dev = ( (uint32)'d' << 16U ) | ( (uint32)'e' << 8U ) | (uint32)'v';




struct SteamNetworkingPOPIDRender
{
 SteamNetworkingPOPIDRender( SteamNetworkingPOPID x ) { GetSteamNetworkingLocationPOPStringFromID( x, buf ); }
 inline const char *c_str() const { return buf; }
private:
 char buf[ 8 ];
};
# 1904 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
typedef SteamNetworkingMessage_t ISteamNetworkingMessage;
typedef SteamNetworkingErrMsg SteamDatagramErrMsg;

inline void SteamNetworkingIPAddr::Clear() { memset( this, 0, sizeof(*this) ); }
inline bool SteamNetworkingIPAddr::IsIPv6AllZeros() const { uint64 q[2] = {}; memcpy(q, m_ipv6, sizeof(m_ipv6)); return q[0] == 0 && q[1] == 0; }
inline void SteamNetworkingIPAddr::SetIPv6( const uint8 *ipv6, uint16 nPort ) { memcpy( m_ipv6, ipv6, 16 ); m_port = nPort; }
inline void SteamNetworkingIPAddr::SetIPv4( uint32 nIP, uint16 nPort ) { m_ipv4.m_8zeros = 0; m_ipv4.m_0000 = 0; m_ipv4.m_ffff = 0xffff; m_ipv4.m_ip[0] = uint8(nIP>>24); m_ipv4.m_ip[1] = uint8(nIP>>16); m_ipv4.m_ip[2] = uint8(nIP>>8); m_ipv4.m_ip[3] = uint8(nIP); m_port = nPort; }
inline bool SteamNetworkingIPAddr::IsIPv4() const { return m_ipv4.m_8zeros == 0 && m_ipv4.m_0000 == 0 && m_ipv4.m_ffff == 0xffff; }
inline uint32 SteamNetworkingIPAddr::GetIPv4() const { return IsIPv4() ? ( (uint32(m_ipv4.m_ip[0])<<24) | (uint32(m_ipv4.m_ip[1])<<16) | (uint32(m_ipv4.m_ip[2])<<8) | uint32(m_ipv4.m_ip[3]) ) : 0; }
inline void SteamNetworkingIPAddr::SetIPv6LocalHost( uint16 nPort ) { m_ipv4.m_8zeros = 0; m_ipv4.m_0000 = 0; m_ipv4.m_ffff = 0; m_ipv6[12] = 0; m_ipv6[13] = 0; m_ipv6[14] = 0; m_ipv6[15] = 1; m_port = nPort; }
inline bool SteamNetworkingIPAddr::IsLocalHost() const { return ( m_ipv4.m_8zeros == 0 && m_ipv4.m_0000 == 0 && m_ipv4.m_ffff == 0 && m_ipv6[12] == 0 && m_ipv6[13] == 0 && m_ipv6[14] == 0 && m_ipv6[15] == 1 ) || ( GetIPv4() == 0x7f000001 ); }
inline bool SteamNetworkingIPAddr::operator==(const SteamNetworkingIPAddr &x ) const { return memcmp( this, &x, sizeof(SteamNetworkingIPAddr) ) == 0; }

inline void SteamNetworkingIdentity::Clear() { memset( this, 0, sizeof(*this) ); }
inline bool SteamNetworkingIdentity::IsInvalid() const { return m_eType == k_ESteamNetworkingIdentityType_Invalid; }
inline void SteamNetworkingIdentity::SetSteamID( CSteamID steamID ) { SetSteamID64( steamID.ConvertToUint64() ); }
inline CSteamID SteamNetworkingIdentity::GetSteamID() const { return CSteamID( GetSteamID64() ); }
inline void SteamNetworkingIdentity::SetSteamID64( uint64 steamID ) { m_eType = k_ESteamNetworkingIdentityType_SteamID; m_cbSize = sizeof( m_steamID64 ); m_steamID64 = steamID; }
inline uint64 SteamNetworkingIdentity::GetSteamID64() const { return m_eType == k_ESteamNetworkingIdentityType_SteamID ? m_steamID64 : 0; }
inline bool SteamNetworkingIdentity::SetXboxPairwiseID( const char *pszString ) { size_t l = strlen( pszString ); if ( l < 1 || l >= sizeof(m_szXboxPairwiseID) ) return false;
 m_eType = k_ESteamNetworkingIdentityType_XboxPairwiseID; m_cbSize = int(l+1); memcpy( m_szXboxPairwiseID, pszString, m_cbSize ); return true; }
inline const char *SteamNetworkingIdentity::GetXboxPairwiseID() const { return m_eType == k_ESteamNetworkingIdentityType_XboxPairwiseID ? m_szXboxPairwiseID : 
# 1925 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 3 4
                                                                                                                                                              __null
# 1925 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
                                                                                                                                                                  ; }
inline void SteamNetworkingIdentity::SetPSNID( uint64 id ) { m_eType = k_ESteamNetworkingIdentityType_SonyPSN; m_cbSize = sizeof( m_PSNID ); m_PSNID = id; }
inline uint64 SteamNetworkingIdentity::GetPSNID() const { return m_eType == k_ESteamNetworkingIdentityType_SonyPSN ? m_PSNID : 0; }
inline void SteamNetworkingIdentity::SetIPAddr( const SteamNetworkingIPAddr &addr ) { m_eType = k_ESteamNetworkingIdentityType_IPAddress; m_cbSize = (int)sizeof(m_ip); m_ip = addr; }
inline const SteamNetworkingIPAddr *SteamNetworkingIdentity::GetIPAddr() const { return m_eType == k_ESteamNetworkingIdentityType_IPAddress ? &m_ip : 
# 1929 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 3 4
                                                                                                                                                     __null
# 1929 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
                                                                                                                                                         ; }
inline void SteamNetworkingIdentity::SetIPv4Addr( uint32 nIPv4, uint16 nPort ) { m_eType = k_ESteamNetworkingIdentityType_IPAddress; m_cbSize = (int)sizeof(m_ip); m_ip.SetIPv4( nIPv4, nPort ); }
inline uint32 SteamNetworkingIdentity::GetIPv4() const { return m_eType == k_ESteamNetworkingIdentityType_IPAddress ? m_ip.GetIPv4() : 0; }
inline ESteamNetworkingFakeIPType SteamNetworkingIdentity::GetFakeIPType() const { return m_eType == k_ESteamNetworkingIdentityType_IPAddress ? m_ip.GetFakeIPType() : k_ESteamNetworkingFakeIPType_Invalid; }
inline void SteamNetworkingIdentity::SetLocalHost() { m_eType = k_ESteamNetworkingIdentityType_IPAddress; m_cbSize = (int)sizeof(m_ip); m_ip.SetIPv6LocalHost(); }
inline bool SteamNetworkingIdentity::IsLocalHost() const { return m_eType == k_ESteamNetworkingIdentityType_IPAddress && m_ip.IsLocalHost(); }
inline bool SteamNetworkingIdentity::SetGenericString( const char *pszString ) { size_t l = strlen( pszString ); if ( l >= sizeof(m_szGenericString) ) return false;
 m_eType = k_ESteamNetworkingIdentityType_GenericString; m_cbSize = int(l+1); memcpy( m_szGenericString, pszString, m_cbSize ); return true; }
inline const char *SteamNetworkingIdentity::GetGenericString() const { return m_eType == k_ESteamNetworkingIdentityType_GenericString ? m_szGenericString : 
# 1937 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 3 4
                                                                                                                                                           __null
# 1937 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
                                                                                                                                                               ; }
inline bool SteamNetworkingIdentity::SetGenericBytes( const void *data, size_t cbLen ) { if ( cbLen > sizeof(m_genericBytes) ) return false;
 m_eType = k_ESteamNetworkingIdentityType_GenericBytes; m_cbSize = int(cbLen); memcpy( m_genericBytes, data, m_cbSize ); return true; }
inline const uint8 *SteamNetworkingIdentity::GetGenericBytes( int &cbLen ) const { if ( m_eType != k_ESteamNetworkingIdentityType_GenericBytes ) return 
# 1940 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h" 3 4
                                                                                                                                                       __null
# 1940 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingtypes.h"
                                                                                                                                                           ;
 cbLen = m_cbSize; return m_genericBytes; }
inline bool SteamNetworkingIdentity::operator==(const SteamNetworkingIdentity &x ) const { return m_eType == x.m_eType && m_cbSize == x.m_cbSize && memcmp( m_genericBytes, x.m_genericBytes, m_cbSize ) == 0; }
inline void SteamNetworkingMessage_t::Release() { (*m_pfnRelease)( this ); }
# 8 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steam_api_common.h" 1


       
# 12 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steam_api_common.h"
enum { k_iSteamNetworkingSocketsCallbacks = 1220 };
enum { k_iSteamNetworkingMessagesCallbacks = 1250 };
enum { k_iSteamNetworkingUtilsCallbacks = 1280 };


typedef int32 HSteamPipe;

typedef int32 HSteamUser;
# 9 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h" 2

struct SteamNetAuthenticationStatus_t;
struct SteamNetworkingFakeIPResult_t;
class ISteamNetworkingConnectionSignaling;
class ISteamNetworkingSignalingRecvContext;
class ISteamNetworkingFakeUDPPort;
# 42 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
class ISteamNetworkingSockets
{
public:
# 65 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamListenSocket CreateListenSocketIP( const SteamNetworkingIPAddr &localAddress, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 89 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamNetConnection ConnectByIPAddress( const SteamNetworkingIPAddr &address, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 114 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamListenSocket CreateListenSocketP2P( int nLocalVirtualPort, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 127 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamNetConnection ConnectP2P( const SteamNetworkingIdentity &identityRemote, int nRemoteVirtualPort, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 168 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult AcceptConnection( HSteamNetConnection hConn ) = 0;
# 191 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool CloseConnection( HSteamNetConnection hPeer, int nReason, const char *pszDebug, bool bEnableLinger ) = 0;



 virtual bool CloseListenSocket( HSteamListenSocket hSocket ) = 0;
# 219 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool SetConnectionUserData( HSteamNetConnection hPeer, int64 nUserData ) = 0;



 virtual int64 GetConnectionUserData( HSteamNetConnection hPeer ) = 0;


 virtual void SetConnectionName( HSteamNetConnection hPeer, const char *pszName ) = 0;


 virtual bool GetConnectionName( HSteamNetConnection hPeer, char *pszName, int nMaxLen ) = 0;
# 268 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult SendMessageToConnection( HSteamNetConnection hConn, const void *pData, uint32 cbData, int nSendFlags, int64 *pOutMessageNumber ) = 0;
# 322 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual void SendMessages( int nMessages, SteamNetworkingMessage_t **pMessages, int64 *pOutMessageNumberOrResult, bool bDeleteFailedMessages ) = 0;
# 337 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult FlushMessagesOnConnection( HSteamNetConnection hConn ) = 0;
# 354 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual int ReceiveMessagesOnConnection( HSteamNetConnection hConn, SteamNetworkingMessage_t **ppOutMessages, int nMaxMessages ) = 0;


 virtual bool GetConnectionInfo( HSteamNetConnection hConn, SteamNetConnectionInfo_t *pInfo ) = 0;
# 373 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult GetConnectionRealTimeStatus( HSteamNetConnection hConn, SteamNetConnectionRealTimeStatus_t *pStatus,
  int nLanes, SteamNetConnectionRealTimeLaneStatus_t *pLanes ) = 0;
# 384 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual int GetDetailedConnectionStatus( HSteamNetConnection hConn, char *pszBuf, int cbBuf ) = 0;





 virtual bool GetListenSocketAddress( HSteamListenSocket hSocket, SteamNetworkingIPAddr *address ) = 0;
# 417 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool CreateSocketPair( HSteamNetConnection *pOutConnection1, HSteamNetConnection *pOutConnection2, bool bUseNetworkLoopback, const SteamNetworkingIdentity *pPeerIdentity1, const SteamNetworkingIdentity *pPeerIdentity2 ) = 0;
# 486 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult ConfigureConnectionLanes( HSteamNetConnection hConn, int nNumLanes, const int *pLanePriorities, const uint16 *pLaneWeights ) = 0;
# 497 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool GetIdentity( SteamNetworkingIdentity *pIdentity ) = 0;
# 522 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual ESteamNetworkingAvailability InitAuthentication() = 0;
# 531 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual ESteamNetworkingAvailability GetAuthenticationStatus( SteamNetAuthenticationStatus_t *pDetails ) = 0;
# 542 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamNetPollGroup CreatePollGroup() = 0;






 virtual bool DestroyPollGroup( HSteamNetPollGroup hPollGroup ) = 0;
# 565 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool SetConnectionPollGroup( HSteamNetConnection hConn, HSteamNetPollGroup hPollGroup ) = 0;
# 582 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual int ReceiveMessagesOnPollGroup( HSteamNetPollGroup hPollGroup, SteamNetworkingMessage_t **ppOutMessages, int nMaxMessages ) = 0;
# 595 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool ReceivedRelayAuthTicket( const void *pvTicket, int cbTicket, SteamDatagramRelayAuthTicket *pOutParsedTicket ) = 0;







 virtual int FindRelayAuthTicketForServer( const SteamNetworkingIdentity &identityGameServer, int nRemoteVirtualPort, SteamDatagramRelayAuthTicket *pOutParsedTicket ) = 0;
# 621 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamNetConnection ConnectToHostedDedicatedServer( const SteamNetworkingIdentity &identityTarget, int nRemoteVirtualPort, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 634 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual uint16 GetHostedDedicatedServerPort() = 0;



 virtual SteamNetworkingPOPID GetHostedDedicatedServerPOPID() = 0;
# 666 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult GetHostedDedicatedServerAddress( SteamDatagramHostedAddress *pRouting ) = 0;
# 681 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamListenSocket CreateHostedDedicatedServerListenSocket( int nLocalVirtualPort, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 713 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult GetGameCoordinatorServerLogin( SteamDatagramGameCoordinatorServerLogin *pLoginInfo, int *pcbSignedBlob, void *pBlob ) = 0;
# 756 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamNetConnection ConnectP2PCustomSignaling( ISteamNetworkingConnectionSignaling *pSignaling, const SteamNetworkingIdentity *pPeerIdentity, int nRemoteVirtualPort, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 787 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool ReceivedP2PCustomSignal( const void *pMsg, int cbMsg, ISteamNetworkingSignalingRecvContext *pContext ) = 0;
# 800 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool GetCertificateRequest( int *pcbBlob, void *pBlob, SteamNetworkingErrMsg &errMsg ) = 0;



 virtual bool SetCertificate( const void *pCertificate, int cbCertificate, SteamNetworkingErrMsg &errMsg ) = 0;
# 814 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual void ResetIdentity( const SteamNetworkingIdentity *pIdentity ) = 0;
# 825 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual void RunCallbacks() = 0;
# 887 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual bool BeginAsyncRequestFakeIP( int nNumPorts ) = 0;




 virtual void GetFakeIP( int idxFirstPort, SteamNetworkingFakeIPResult_t *pInfo ) = 0;
# 903 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual HSteamListenSocket CreateListenSocketP2PFakeIP( int idxFakePort, int nOptions, const SteamNetworkingConfigValue_t *pOptions ) = 0;
# 920 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual EResult GetRemoteFakeIPForConnection( HSteamNetConnection hConn, SteamNetworkingIPAddr *pOutAddr ) = 0;
# 939 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
 virtual ISteamNetworkingFakeUDPPort *CreateFakeUDPPort( int idxFakeServerPort ) = 0;

protected:
 ~ISteamNetworkingSockets();
};







 static_assert( "SteamNetworkingSockets012"[24] == '2', "Version mismatch" );
 extern "C" ISteamNetworkingSockets *SteamNetworkingSockets_LibV12();
 inline ISteamNetworkingSockets *SteamNetworkingSockets_Lib() { return SteamNetworkingSockets_LibV12(); }

 extern "C" ISteamNetworkingSockets *SteamGameServerNetworkingSockets_LibV12();
 inline ISteamNetworkingSockets *SteamGameServerNetworkingSockets_Lib() { return SteamGameServerNetworkingSockets_LibV12(); }


  inline ISteamNetworkingSockets *SteamNetworkingSockets() { return SteamNetworkingSockets_LibV12(); }
  inline ISteamNetworkingSockets *SteamGameServerNetworkingSockets() { return SteamGameServerNetworkingSockets_LibV12(); }
# 977 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
#pragma pack( push, 4 )
# 1019 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
struct SteamNetConnectionStatusChangedCallback_t
{
 enum { k_iCallback = k_iSteamNetworkingSocketsCallbacks + 1 };


 HSteamNetConnection m_hConn;


 SteamNetConnectionInfo_t m_info;


 ESteamNetworkingConnectionState m_eOldState;
};
# 1041 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingsockets.h"
struct SteamNetAuthenticationStatus_t
{
 enum { k_iCallback = k_iSteamNetworkingSocketsCallbacks + 2 };


 ESteamNetworkingAvailability m_eAvail;



 char m_debugMsg[ 256 ];
};

#pragma pack( pop )
# 4 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/network/server.cppm" 2

# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingsockets.h" 1
# 15 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/steamnetworkingsockets.h"
extern "C" {





extern "C" bool GameNetworkingSockets_Init( const SteamNetworkingIdentity *pIdentity, SteamNetworkingErrMsg &errMsg );


extern "C" void GameNetworkingSockets_Kill();






extern "C" void SteamNetworkingSockets_SetCustomMemoryAllocator(
 void* (*pfn_malloc)( size_t s ),
 void (*pfn_free)( void *p ),
 void* (*pfn_realloc)( void *p, size_t s )
);





extern "C" void SteamNetworkingSockets_SetLockWaitWarningThreshold( SteamNetworkingMicroseconds usecThreshold );
extern "C" void SteamNetworkingSockets_SetLockAcquiredCallback( void (*callback)( const char *tags, SteamNetworkingMicroseconds usecWaited ) );
extern "C" void SteamNetworkingSockets_SetLockHeldCallback( void (*callback)( const char *tags, SteamNetworkingMicroseconds usecWaited ) );



extern "C" void SteamNetworkingSockets_SetServiceThreadInitCallback( void (*callback)() );

}
# 6 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/network/server.cppm" 2
# 1 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h" 1
# 9 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
       




struct SteamDatagramRelayAuthTicket;
struct SteamRelayNetworkStatus_t;




class ISteamNetworkingUtils
{
public:
# 41 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual SteamNetworkingMessage_t *AllocateMessage( int cbAllocateBuffer ) = 0;
# 71 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 inline void InitRelayNetworkAccess();
# 81 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual ESteamNetworkingAvailability GetRelayNetworkStatus( SteamRelayNetworkStatus_t *pDetails ) = 0;
# 110 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual float GetLocalPingLocation( SteamNetworkPingLocation_t &result ) = 0;
# 134 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual int EstimatePingTimeBetweenTwoLocations( const SteamNetworkPingLocation_t &location1, const SteamNetworkPingLocation_t &location2 ) = 0;
# 144 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual int EstimatePingTimeFromLocalHost( const SteamNetworkPingLocation_t &remoteLocation ) = 0;





 virtual void ConvertPingLocationToString( const SteamNetworkPingLocation_t &location, char *pszBuf, int cchBufSize ) = 0;



 virtual bool ParsePingLocationString( const char *pszString, SteamNetworkPingLocation_t &result ) = 0;
# 174 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual bool CheckPingDataUpToDate( float flMaxAgeSeconds ) = 0;
# 184 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual int GetPingToDataCenter( SteamNetworkingPOPID popID, SteamNetworkingPOPID *pViaRelayPoP ) = 0;


 virtual int GetDirectPingToPOP( SteamNetworkingPOPID popID ) = 0;


 virtual int GetPOPCount() = 0;



 virtual int GetPOPList( SteamNetworkingPOPID *list, int nListSz ) = 0;
# 217 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual SteamNetworkingMicroseconds GetLocalTimestamp() = 0;
# 242 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual void SetDebugOutputFunction( ESteamNetworkingSocketsDebugOutputType eDetailLevel, FSteamNetworkingSocketsDebugOutput pfnFunc ) = 0;
# 253 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 inline bool IsFakeIPv4( uint32 nIPv4 ) { return GetIPv4FakeIPType( nIPv4 ) > k_ESteamNetworkingFakeIPType_NotFake; }
 virtual ESteamNetworkingFakeIPType GetIPv4FakeIPType( uint32 nIPv4 ) = 0;
# 268 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual EResult GetRealIdentityForFakeIP( const SteamNetworkingIPAddr &fakeIP, SteamNetworkingIdentity *pOutRealIdentity ) = 0;






 bool SetGlobalConfigValueInt32( ESteamNetworkingConfigValue eValue, int32 val );
 bool SetGlobalConfigValueFloat( ESteamNetworkingConfigValue eValue, float val );
 bool SetGlobalConfigValueString( ESteamNetworkingConfigValue eValue, const char *val );
 bool SetGlobalConfigValuePtr( ESteamNetworkingConfigValue eValue, void *val );
 bool SetConnectionConfigValueInt32( HSteamNetConnection hConn, ESteamNetworkingConfigValue eValue, int32 val );
 bool SetConnectionConfigValueFloat( HSteamNetConnection hConn, ESteamNetworkingConfigValue eValue, float val );
 bool SetConnectionConfigValueString( HSteamNetConnection hConn, ESteamNetworkingConfigValue eValue, const char *val );







 bool SetGlobalCallback_SteamNetConnectionStatusChanged( FnSteamNetConnectionStatusChanged fnCallback );
 bool SetGlobalCallback_SteamNetAuthenticationStatusChanged( FnSteamNetAuthenticationStatusChanged fnCallback );
 bool SetGlobalCallback_SteamRelayNetworkStatusChanged( FnSteamRelayNetworkStatusChanged fnCallback );
 bool SetGlobalCallback_FakeIPResult( FnSteamNetworkingFakeIPResult fnCallback );
 bool SetGlobalCallback_MessagesSessionRequest( FnSteamNetworkingMessagesSessionRequest fnCallback );
 bool SetGlobalCallback_MessagesSessionFailed( FnSteamNetworkingMessagesSessionFailed fnCallback );
# 306 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual bool SetConfigValue( ESteamNetworkingConfigValue eValue, ESteamNetworkingConfigScope eScopeType, intptr_t scopeObj,
  ESteamNetworkingConfigDataType eDataType, const void *pArg ) = 0;





 bool SetConfigValueStruct( const SteamNetworkingConfigValue_t &opt, ESteamNetworkingConfigScope eScopeType, intptr_t scopeObj );
# 322 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual ESteamNetworkingGetConfigValueResult GetConfigValue( ESteamNetworkingConfigValue eValue, ESteamNetworkingConfigScope eScopeType, intptr_t scopeObj,
  ESteamNetworkingConfigDataType *pOutDataType, void *pResult, size_t *cbResult ) = 0;




 virtual const char *GetConfigValueInfo( ESteamNetworkingConfigValue eValue, ESteamNetworkingConfigDataType *pOutDataType,
  ESteamNetworkingConfigScope *pOutScope ) = 0;
# 339 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
 virtual ESteamNetworkingConfigValue IterateGenericEditableConfigValues( ESteamNetworkingConfigValue eCurrent, bool bEnumerateDevVars ) = 0;





 virtual void SteamNetworkingIPAddr_ToString( const SteamNetworkingIPAddr &addr, char *buf, size_t cbBuf, bool bWithPort ) = 0;
 virtual bool SteamNetworkingIPAddr_ParseString( SteamNetworkingIPAddr *pAddr, const char *pszStr ) = 0;
 virtual ESteamNetworkingFakeIPType SteamNetworkingIPAddr_GetFakeIPType( const SteamNetworkingIPAddr &addr ) = 0;
 virtual void SteamNetworkingIdentity_ToString( const SteamNetworkingIdentity &identity, char *buf, size_t cbBuf ) = 0;
 virtual bool SteamNetworkingIdentity_ParseString( SteamNetworkingIdentity *pIdentity, const char *pszStr ) = 0;

protected:
 ~ISteamNetworkingUtils();
};







 static_assert( "SteamNetworkingUtils004"[22] == '4', "Version mismatch" );
 extern "C" ISteamNetworkingUtils *SteamNetworkingUtils_LibV4();
 inline ISteamNetworkingUtils *SteamNetworkingUtils_Lib() { return SteamNetworkingUtils_LibV4(); }


  inline ISteamNetworkingUtils *SteamNetworkingUtils() { return SteamNetworkingUtils_LibV4(); }
# 390 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/external/GameNetworkingSockets/src/../include/steam/isteamnetworkingutils.h"
struct SteamRelayNetworkStatus_t
{
 enum { k_iCallback = k_iSteamNetworkingUtilsCallbacks + 1 };




 ESteamNetworkingAvailability m_eAvail;



 int m_bPingMeasurementInProgress;






 ESteamNetworkingAvailability m_eAvailNetworkConfig;






 ESteamNetworkingAvailability m_eAvailAnyRelay;



 char m_debugMsg[ 256 ];
};





struct SteamNetworkingIdentityRender
{
 SteamNetworkingIdentityRender( const SteamNetworkingIdentity &x ) { x.ToString( buf, sizeof(buf) ); }
 inline const char *c_str() const { return buf; }
private:
 char buf[ SteamNetworkingIdentity::k_cchMaxString ];
};


struct SteamNetworkingIPAddrRender
{
 SteamNetworkingIPAddrRender( const SteamNetworkingIPAddr &x, bool bWithPort = true ) { x.ToString( buf, sizeof(buf), bWithPort ); }
 inline const char *c_str() const { return buf; }
private:
 char buf[ SteamNetworkingIPAddr::k_cchMaxString ];
};







inline void ISteamNetworkingUtils::InitRelayNetworkAccess() { CheckPingDataUpToDate( 1e10f ); }
inline bool ISteamNetworkingUtils::SetGlobalConfigValueInt32( ESteamNetworkingConfigValue eValue, int32 val ) { return SetConfigValue( eValue, k_ESteamNetworkingConfig_Global, 0, k_ESteamNetworkingConfig_Int32, &val ); }
inline bool ISteamNetworkingUtils::SetGlobalConfigValueFloat( ESteamNetworkingConfigValue eValue, float val ) { return SetConfigValue( eValue, k_ESteamNetworkingConfig_Global, 0, k_ESteamNetworkingConfig_Float, &val ); }
inline bool ISteamNetworkingUtils::SetGlobalConfigValueString( ESteamNetworkingConfigValue eValue, const char *val ) { return SetConfigValue( eValue, k_ESteamNetworkingConfig_Global, 0, k_ESteamNetworkingConfig_String, val ); }
inline bool ISteamNetworkingUtils::SetGlobalConfigValuePtr( ESteamNetworkingConfigValue eValue, void *val ) { return SetConfigValue( eValue, k_ESteamNetworkingConfig_Global, 0, k_ESteamNetworkingConfig_Ptr, &val ); }
inline bool ISteamNetworkingUtils::SetConnectionConfigValueInt32( HSteamNetConnection hConn, ESteamNetworkingConfigValue eValue, int32 val ) { return SetConfigValue( eValue, k_ESteamNetworkingConfig_Connection, hConn, k_ESteamNetworkingConfig_Int32, &val ); }
inline bool ISteamNetworkingUtils::SetConnectionConfigValueFloat( HSteamNetConnection hConn, ESteamNetworkingConfigValue eValue, float val ) { return SetConfigValue( eValue, k_ESteamNetworkingConfig_Connection, hConn, k_ESteamNetworkingConfig_Float, &val ); }
inline bool ISteamNetworkingUtils::SetConnectionConfigValueString( HSteamNetConnection hConn, ESteamNetworkingConfigValue eValue, const char *val ) { return SetConfigValue( eValue, k_ESteamNetworkingConfig_Connection, hConn, k_ESteamNetworkingConfig_String, val ); }
inline bool ISteamNetworkingUtils::SetGlobalCallback_SteamNetConnectionStatusChanged( FnSteamNetConnectionStatusChanged fnCallback ) { return SetGlobalConfigValuePtr( k_ESteamNetworkingConfig_Callback_ConnectionStatusChanged, (void*)fnCallback ); }
inline bool ISteamNetworkingUtils::SetGlobalCallback_SteamNetAuthenticationStatusChanged( FnSteamNetAuthenticationStatusChanged fnCallback ) { return SetGlobalConfigValuePtr( k_ESteamNetworkingConfig_Callback_AuthStatusChanged, (void*)fnCallback ); }
inline bool ISteamNetworkingUtils::SetGlobalCallback_SteamRelayNetworkStatusChanged( FnSteamRelayNetworkStatusChanged fnCallback ) { return SetGlobalConfigValuePtr( k_ESteamNetworkingConfig_Callback_RelayNetworkStatusChanged, (void*)fnCallback ); }
inline bool ISteamNetworkingUtils::SetGlobalCallback_FakeIPResult( FnSteamNetworkingFakeIPResult fnCallback ) { return SetGlobalConfigValuePtr( k_ESteamNetworkingConfig_Callback_FakeIPResult, (void*)fnCallback ); }
inline bool ISteamNetworkingUtils::SetGlobalCallback_MessagesSessionRequest( FnSteamNetworkingMessagesSessionRequest fnCallback ) { return SetGlobalConfigValuePtr( k_ESteamNetworkingConfig_Callback_MessagesSessionRequest, (void*)fnCallback ); }
inline bool ISteamNetworkingUtils::SetGlobalCallback_MessagesSessionFailed( FnSteamNetworkingMessagesSessionFailed fnCallback ) { return SetGlobalConfigValuePtr( k_ESteamNetworkingConfig_Callback_MessagesSessionFailed, (void*)fnCallback ); }

inline bool ISteamNetworkingUtils::SetConfigValueStruct( const SteamNetworkingConfigValue_t &opt, ESteamNetworkingConfigScope eScopeType, intptr_t scopeObj )
{




 const void *pVal = ( opt.m_eDataType == k_ESteamNetworkingConfig_String ) ? (const void *)opt.m_val.m_string : (const void *)&opt.m_val;
 return SetConfigValue( opt.m_eValue, eScopeType, scopeObj, opt.m_eDataType, pVal );
}





 extern "C" void SteamNetworkingIPAddr_ToString( const SteamNetworkingIPAddr *pAddr, char *buf, size_t cbBuf, bool bWithPort );
 extern "C" bool SteamNetworkingIPAddr_ParseString( SteamNetworkingIPAddr *pAddr, const char *pszStr );
 extern "C" ESteamNetworkingFakeIPType SteamNetworkingIPAddr_GetFakeIPType( const SteamNetworkingIPAddr *pAddr );
 extern "C" void SteamNetworkingIdentity_ToString( const SteamNetworkingIdentity *pIdentity, char *buf, size_t cbBuf );
 extern "C" bool SteamNetworkingIdentity_ParseString( SteamNetworkingIdentity *pIdentity, size_t sizeofIdentity, const char *pszStr );
 inline void SteamNetworkingIPAddr::ToString( char *buf, size_t cbBuf, bool bWithPort ) const { SteamNetworkingIPAddr_ToString( this, buf, cbBuf, bWithPort ); }
 inline bool SteamNetworkingIPAddr::ParseString( const char *pszStr ) { return SteamNetworkingIPAddr_ParseString( this, pszStr ); }
 inline ESteamNetworkingFakeIPType SteamNetworkingIPAddr::GetFakeIPType() const { return SteamNetworkingIPAddr_GetFakeIPType( this ); }
 inline void SteamNetworkingIdentity::ToString( char *buf, size_t cbBuf ) const { SteamNetworkingIdentity_ToString( this, buf, cbBuf ); }
 inline bool SteamNetworkingIdentity::ParseString( const char *pszStr ) { return SteamNetworkingIdentity_ParseString( this, sizeof(*this), pszStr ); }
# 7 "/home/pietroth/Cpp/TSA/TSA/external/LightnerX/network/server.cppm" 2

export module network.server;

import std;

import network.network_manager;

export namespace network {
    constexpr HSteamListenSocket k_invalidSocket = 0;
    constexpr HSteamNetPollGroup k_invalidPollGroup = 0;

    class Server {
    private:
        ISteamNetworkingSockets* m_pInterface = nullptr;
        HSteamListenSocket m_hListenSocket = k_invalidSocket;
        HSteamNetPollGroup m_hPollGroup = k_invalidPollGroup;

        using ClientConnectedCallback = std::function<void(HSteamNetConnection)>;
        std::vector<ClientConnectedCallback> clientConnectedCallbacks;

        using ClientDisconnectedCallback = std::function<void(HSteamNetConnection)>;
        std::vector<ClientDisconnectedCallback> clientDisconnectedCallbacks;

        using ClientReceivedMessageCallback = std::function<void(std::span<const std::byte>, HSteamNetConnection)>;
        std::vector<ClientReceivedMessageCallback> clientReceivedMessageCallbacks;

    public:
        void addClientConnectedCallback(ClientConnectedCallback callback) {
            clientConnectedCallbacks.push_back(callback);
        }

        void addClientDisconnectedCallback(ClientDisconnectedCallback callback) {
            clientDisconnectedCallbacks.push_back(callback);
        }

        void addClientReceivedMessageCallback(ClientReceivedMessageCallback callback) {
            clientReceivedMessageCallbacks.push_back(callback);
        }

        std::expected<void, std::error_code> start(int port, uint32_t timeoutConnected) {
            if (!network::networkInit()) {
                return std::unexpected(
                    std::make_error_code(std::errc::io_error)
                );
            }

            m_pInterface = SteamNetworkingSockets();

            SteamNetworkingIPAddr address;
            address.Clear();
            address.m_port = port;

            s_pCallbackInstance = this;

            SteamNetworkingConfigValue_t options[2];

            options[0].SetPtr(
                k_ESteamNetworkingConfig_Callback_ConnectionStatusChanged,
                reinterpret_cast<void*>(SteamNetConnectionStatusChangedCallback)
            );

            options[1].SetInt32(
                k_ESteamNetworkingConfig_TimeoutConnected,
                timeoutConnected
            );

            m_hListenSocket = m_pInterface->CreateListenSocketIP(
                address,
                2,
                options
            );

            if (m_hListenSocket == k_invalidSocket) {
                s_pCallbackInstance = nullptr;
                GameNetworkingSockets_Kill();

                std::println(std::cerr, "Failed to create listen socket.");
                return std::unexpected(std::make_error_code(std::errc::resource_unavailable_try_again));
            }

            m_hPollGroup = m_pInterface->CreatePollGroup();

            if (m_hPollGroup == k_invalidPollGroup) {
                s_pCallbackInstance = nullptr;
                m_pInterface->CloseListenSocket(m_hListenSocket);
                GameNetworkingSockets_Kill();

                std::println(std::cerr, "Failed to create poll group.");
                return std::unexpected(std::make_error_code(std::errc::resource_unavailable_try_again));
            }

            return {};
        }

        std::expected<void, std::error_code> update() {
            m_pInterface->RunCallbacks();

            ISteamNetworkingMessage* message = nullptr;

            int received = m_pInterface->ReceiveMessagesOnPollGroup(
                m_hPollGroup,
                &message,
                1
            );

            if (received > 0) {
                for (const auto& callback : clientReceivedMessageCallbacks) {
                    callback({
                        static_cast<const std::byte*>(message->m_pData),
                        static_cast<std::size_t>(message->m_cbSize)
                        },
                        message->m_conn
                    );
                }
                message->Release();
            }

            return {};
        }

        std::expected<void, std::error_code> disconnectConnection(
            HSteamNetConnection hConn, bool enableLinger
        ) {
            if (!network::isNetworkInitialized()) {
                return std::unexpected(
                    std::make_error_code(std::errc::not_connected)
                );
            }

            ISteamNetworkingSockets* sockets = SteamNetworkingSockets();

            if (!sockets->CloseConnection(
                hConn,
                k_ESteamNetConnectionEnd_App_Generic,
                nullptr,
                enableLinger
            )) {
                return std::unexpected(
                    std::make_error_code(std::errc::io_error)
                );;
            }

            for (const auto& callback : clientDisconnectedCallbacks) {
                callback(hConn);
            }

            return {};
        }

        void close() {
            if (m_pInterface == nullptr) {
                return;
            }

            if (m_hListenSocket != k_invalidSocket) {
                m_pInterface->CloseListenSocket(m_hListenSocket);
                m_hListenSocket = k_invalidSocket;
            }

            if (m_hPollGroup != k_invalidPollGroup) {
                m_pInterface->DestroyPollGroup(m_hPollGroup);
                m_hPollGroup = k_invalidPollGroup;
            }

            m_pInterface = nullptr;
            s_pCallbackInstance = nullptr;

            GameNetworkingSockets_Kill();
        }

        private:
            inline static Server* s_pCallbackInstance = nullptr;

            static void SteamNetConnectionStatusChangedCallback(
                SteamNetConnectionStatusChangedCallback_t* pInfo
            ) {
                if (s_pCallbackInstance != nullptr) {
                    s_pCallbackInstance->OnConnectionStatusChanged(pInfo);
                }
            }

            void OnConnectionStatusChanged(SteamNetConnectionStatusChangedCallback_t* pInfo) {
                HSteamNetConnection hConn = pInfo->m_hConn;
                SteamNetConnectionInfo_t info = pInfo->m_info;

                switch (info.m_eState) {
                    case k_ESteamNetworkingConnectionState_None:
                            break;

                    case k_ESteamNetworkingConnectionState_Connecting:
                        if (m_pInterface->AcceptConnection(hConn) != k_EResultOK) {
                            m_pInterface->CloseConnection(hConn, 0, nullptr, false);
                            break;
                        }

                        if (!m_pInterface->SetConnectionPollGroup(hConn, m_hPollGroup)) {
                            m_pInterface->CloseConnection(hConn, 0, nullptr, false);
                            break;
                        }

                        for (const auto& clientConnectedCallback : clientConnectedCallbacks) {
                            clientConnectedCallback(hConn);
                        }

                        break;

                    case k_ESteamNetworkingConnectionState_FindingRoute:
                    case k_ESteamNetworkingConnectionState_FinWait:
                    case k_ESteamNetworkingConnectionState_Linger:
                    case k_ESteamNetworkingConnectionState_Dead:
                    case k_ESteamNetworkingConnectionState__Force32Bit:
                    case k_ESteamNetworkingConnectionState_Connected:
                        break;

                    case k_ESteamNetworkingConnectionState_ClosedByPeer:
                    case k_ESteamNetworkingConnectionState_ProblemDetectedLocally : {
                        const HSteamNetConnection hConn = pInfo->m_hConn;
                        m_pInterface->CloseConnection(hConn, 0, nullptr, false);

                        for (const auto& callback : clientDisconnectedCallbacks) {
                            callback(hConn);
                        }

                        break;
                    }
                }
            }
    };

}
