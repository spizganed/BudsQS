package com.oplus.melody.model.net;

import com.oplus.melody.alive.component.speechfind.SpeechFindManager;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: compiled from: SmartHomeIotService.java */
/* JADX INFO: loaded from: classes3.dex */
interface G {
    @dd.o("v1/earphone/resource/fetch")
    CompletableFuture<String> a(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/personalize/list_series")
    CompletableFuture<String> b(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/resource/{type}")
    CompletableFuture<String> c(@dd.s(SpeechFindManager.TYPE) String str, @dd.j Map<String, String> map, @dd.a String str2);

    @dd.o("v1/earphone/meditate")
    CompletableFuture<String> d(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/policyResources")
    CompletableFuture<String> e(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/firmwareInfo")
    CompletableFuture<String> f(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/firmwareCoverImage")
    CompletableFuture<String> g(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/personalize/list_series_theme")
    CompletableFuture<String> h(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/personalize/get_default_theme")
    CompletableFuture<String> i(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/firmwareImage")
    CompletableFuture<String> j(@dd.j Map<String, String> map, @dd.a String str);

    @dd.o("v1/earphone/personalize/list_theme")
    CompletableFuture<String> k(@dd.j Map<String, String> map, @dd.a String str);

    @dd.w
    @dd.f
    CompletableFuture<uc.s> l(@dd.y String str, @dd.j Map<String, String> map);
}
