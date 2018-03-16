package net.mycronite.cataclysm.blocks;

import net.mycronite.cataclysm.Cataclysm;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGapingMaw extends Block implements ITileEntityProvider
{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    
   public BlockGapingMaw()
   {
       super(Material.ROCK);
       
       setUnlocalizedName(Cataclysm.MODID+".blockgapingmaw");
       setRegistryName("blockgapingmaw");
       setCreativeTab(CreativeTabs.REDSTONE);
   }
   
   @SideOnly(Side.CLIENT)
   public void initModel() 
   {
       ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new
               ModelResourceLocation(getRegistryName(), "inventory"));
   }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) 
    {
        return new TileEntityGapingMaw();
    }
    
    private TileEntityGapingMaw getTE(World world, BlockPos pos)
    {
        return (TileEntityGapingMaw) world.getTileEntity(pos);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
            EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote){
            // count on the server side
            
            if(side == state.getValue(FACING))
            {
                int counter;
                if (hitY < .5f)
                {
                    counter = getTE(world, pos).decrement();
                }
                else
                {
                    counter = getTE(world, pos).increment();
                }
                TextComponentTranslation component = new TextComponentTranslation("message.cataclysm.counter_par", counter);
                component.getStyle().setColor(TextFormatting.GREEN);
                player.sendStatusMessage(component,  false);
            }
        }
        
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        world.setBlockState(pos,  state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(FACING,  EnumFacing.getFront((meta & 3) + 2));
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).getIndex() - 2;
    }
    
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }
}
