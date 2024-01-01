/*    */
package net.tntchina.inputFix;
/*    */
/*    */

import com.google.common.collect.ImmutableSet;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

import java.util.Set;

/*    */
/*    */
/*    */
/*    */ public class InputFixTransformer
        /*    */ implements IClassTransformer
        /*    */ {
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    public byte[] transform(String arg0, String arg1, byte[] arg2) {
        /* 61 */
        if ("net.minecraft.client.gui.GuiScreen".equals(arg1))
            /* 62 */ return transform001(arg2);
        /* 63 */
        return arg2;
        /*    */
    }

    /*    */
    /*    */
    /*    */
    private byte[] transform001(byte[] bytes) {
        /* 68 */
        ClassReader classReader = new ClassReader(bytes);
        /* 69 */
        ClassWriter classWriter = new ClassWriter(1);
        /* 70 */
        classReader.accept(new a(classWriter), 8);
        /* 71 */
        return classWriter.toByteArray();
        /*    */
    }

    /*    */   class a
            /*    */ extends ClassVisitor
            /*    */ {
        /*    */ Set<String> names;
        /*    */ String cl;

        /*    */
        /*    */
        public a(ClassVisitor cv) {
            /* 24 */
            super(327680, cv);
            /* 25 */
            this.cl = FMLDeobfuscatingRemapper.INSTANCE.unmap("net/minecraft/client/gui/GuiScreen");
            /* 26 */
            this.names = ImmutableSet.of("func_146282_l", "handleKeyboardInput");
            /*    */
        }

        /*    */
        /*    */
        /*    */
        /*    */
        public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
            /* 32 */
            if (this.names.contains(FMLDeobfuscatingRemapper.INSTANCE.mapMethodName(this.cl, name, desc)) && "()V".equals(desc)) {
                /*    */
                /* 34 */
                MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);
                /* 35 */
                mv.visitCode();
                /* 36 */
                mv.visitVarInsn(25, 0);
                /* 37 */
                mv.visitMethodInsn(184, GuiScreenFix.class.getName().replace(".", "/"), "handleKeyboardInput", "(Lnet/minecraft/client/gui/GuiScreen;)V", false);
                /* 38 */
                mv.visitInsn(177);
                /* 39 */
                mv.visitMaxs(1, 1);
                /* 40 */
                mv.visitEnd();
                /* 41 */
                return new InputFixTransformer.b();
                /*    */
            }
            /* 43 */
            return super.visitMethod(access, name, desc, signature, exceptions);
            /*    */
        }
        /*    */
    }

    /*    */
    /*    */
    /*    */
    /*    */   class b
            /*    */ extends MethodVisitor
            /*    */ {
        /*    */
        public b() {
            /* 53 */
            super(327680, null);
            /*    */
        }
        /*    */
    }
    /*    */
}


/* Location:              D:\IDEA Project\TrueSight\TrueSight-1.8.9-[MOD][1.8.9] deobf\!\net\tntchina\inputFix\InputFixTransformer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */